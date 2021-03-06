package net.sf.esfinge.metadata.properties;

import static net.sf.esfinge.classmock.ClassMockUtils.set;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import net.sf.esfinge.classmock.ClassMock;
import net.sf.esfinge.metadata.AnnotationReader;
import net.sf.esfinge.metadata.container.MetadataRepository;
import net.sf.esfinge.metadata.properties.annotation.IgnoreInComparison;
import net.sf.esfinge.metadata.properties.containers.Container;

public class PropiertiesTest {
	private ClassMock mockBean;
	private Class clazz;

	@Before
	public void createClasses(){
		mockBean = new ClassMock("Bean");
	}
	
	@Before
	public void destroyAnnotation() throws Exception
	{
		MetadataRepository.destroyRepository();
	}

	@Test
	public void testNull() throws Exception {
		clazz = mockBean.createClass();
		
		Object beanA = clazz.newInstance();
		set(beanA, "prop1", 100);
		
		AnnotationReader ar = new AnnotationReader();
		
		Container container = ar.readingAnnotationsTo(clazz, Container.class);
		
		assertTrue(container.getProperties().isEmpty());
		assertTrue(container.getPropertiesList().isEmpty());
		assertTrue(container.getPropertiesSet().isEmpty());
		
	}
	
	@Test
	public void testIgnoreProperty() throws Exception {
		mockBean.addProperty("prop1", int.class);
		mockBean.addAnnotation("prop1", IgnoreInComparison.class);
		clazz = mockBean.createClass();
		
		Object beanA = clazz.newInstance();
		set(beanA, "prop1", 100);
		
		AnnotationReader ar = new AnnotationReader();
		
		Container container = ar.readingAnnotationsTo(clazz, Container.class);
		
		assertEquals(1, container.getProperties().size());
		assertFalse(container.getProperties().isEmpty());
		assertEquals("prop1", container.getPropertyDescriptor("prop1").getName());

		
	}

	@Test
	public void testNaoIgnorandoUmObjeto() throws Exception {
		mockBean.addProperty("prop1", int.class);
		mockBean.addAnnotation("prop1", IgnoreInComparison.class);
		mockBean.addProperty("prop2", int.class);
		
		clazz = mockBean.createClass();
				
		AnnotationReader ar = new AnnotationReader();
		
		Container container = ar.readingAnnotationsTo(clazz, Container.class);
		
		
		
		assertFalse(container.getProperties().isEmpty());
		assertEquals(2, container.getProperties().size());
		assertEquals("prop1", container.getPropertyDescriptor("prop1").getName());
				

	}

	@Test
	public void testRetornaTres() throws Exception {
		mockBean.addProperty("prop1", int.class);
		mockBean.addProperty("prop2", int.class);
		mockBean.addProperty("prop3", String.class);

		clazz = mockBean.createClass();
		
		AnnotationReader ar = new AnnotationReader();
		
		Container container = ar.readingAnnotationsTo(clazz, Container.class);
		
		assertFalse(container.getProperties().isEmpty());
		assertEquals(3, container.getProperties().size());
		assertEquals("prop1", container.getPropertyDescriptor("prop1").getName());
		assertEquals("prop2", container.getPropertyDescriptor("prop2").getName());
		assertEquals("prop3", container.getPropertyDescriptor("prop3").getName());

	}


}
