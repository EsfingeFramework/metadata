package net.sf.esfinge.metadata.properties;

import static net.sf.esfinge.classmock.ClassMockUtils.set;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import net.sf.esfinge.classmock.ClassMock;
import net.sf.esfinge.classmock.api.IClassWriter;
import net.sf.esfinge.classmock.api.enums.LocationEnum;
import net.sf.esfinge.metadata.AnnotationReader;
import net.sf.esfinge.metadata.container.MetadataRepository;
import net.sf.esfinge.metadata.properties.annotation.IgnoreInComparison;
import net.sf.esfinge.metadata.properties.containers.Container;

public class PropiertiesTest {
	private IClassWriter mockBean;
	private Class clazz;
	
	@Before
	public void destroyAnnotation() throws Exception
	{
		MetadataRepository.destroyRepository();
	}

	@Test
	public void testNull() throws Exception {
		IClassWriter mockBean = ClassMock.of("Bean0");
		clazz = mockBean.build();
		
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
		IClassWriter mockBean = ClassMock.of("Bean1");
		mockBean.field("prop1", int.class)
			.annotation(IgnoreInComparison.class, LocationEnum.GETTER);
		
		clazz = mockBean.build();
		
		Object beanA = clazz.getConstructor().newInstance();
		set(beanA, "prop1", 100);
		
		AnnotationReader ar = new AnnotationReader();
		
		Container container = ar.readingAnnotationsTo(clazz, Container.class);
		
		assertEquals(1, container.getProperties().size());
		assertFalse(container.getProperties().isEmpty());
		assertEquals("prop1", container.getPropertyDescriptor("prop1").getName());

		
	}

	@Test
	public void testNaoIgnorandoUmObjeto() throws Exception {
		IClassWriter mockBean = ClassMock.of("Bean2");
		mockBean.field("prop1", int.class)
			.annotation(IgnoreInComparison.class, LocationEnum.GETTER);
		mockBean.field("prop2", int.class);
		clazz = mockBean.build();
				
		AnnotationReader ar = new AnnotationReader();
		
		Container container = ar.readingAnnotationsTo(clazz, Container.class);
		
		
		
		assertFalse(container.getProperties().isEmpty());
		assertEquals(2, container.getProperties().size());
		assertEquals("prop1", container.getPropertyDescriptor("prop1").getName());
				

	}

	@Test
	public void testRetornaTres() throws Exception {
		IClassWriter mockBean = ClassMock.of("Bean3");
		mockBean.field("prop1", int.class);
		mockBean.field("prop2", int.class);
		mockBean.field("prop3", String.class);
		clazz = mockBean.build();
		
		AnnotationReader ar = new AnnotationReader();
		
		Container container = ar.readingAnnotationsTo(clazz, Container.class);
		
		assertFalse(container.getProperties().isEmpty());
		assertEquals(3, container.getProperties().size());
		assertEquals("prop1", container.getPropertyDescriptor("prop1").getName());
		assertEquals("prop2", container.getPropertyDescriptor("prop2").getName());
		assertEquals("prop3", container.getPropertyDescriptor("prop3").getName());

	}


}
