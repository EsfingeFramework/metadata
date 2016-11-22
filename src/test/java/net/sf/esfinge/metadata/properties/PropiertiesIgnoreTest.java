package net.sf.esfinge.metadata.properties;

import static net.sf.esfinge.classmock.ClassMockUtils.set;
import static org.junit.Assert.*;

import org.apache.commons.collections.functors.IfClosure;
import org.junit.Before;
import org.junit.Test;

import net.sf.esfinge.classmock.ClassMock;
import net.sf.esfinge.metadata.properties.containers.*;
import net.sf.esfinge.metadata.AnnotationReader;
import net.sf.esfinge.metadata.properties.annotation.IgnoreInComparison;

public class PropiertiesIgnoreTest {
	private ClassMock mockBean;
	private Class clazz;

	@Before
	public void createClasses(){
		mockBean = new ClassMock("Bean");
		

	}

	@Test
	public void testNull() throws Exception {
		mockBean.addProperty("prop1", int.class);
		mockBean.addAnnotation("prop1", IgnoreInComparison.class);
		clazz = mockBean.createClass();
		
		Object beanA = clazz.newInstance();
		set(beanA, "prop1", 100);
		
		AnnotationReader ar = new AnnotationReader();
		
		ContainerIgnore container = ar.readingAnnotationsTo(clazz, ContainerIgnore.class);
		
		assertTrue(container.getProperties().isEmpty());
		
	}
	
	@Test
	public void testIgnoreProperty() throws Exception {
		mockBean.addProperty("prop1", int.class);
		mockBean.addAnnotation("prop1", IgnoreInComparison.class);
		clazz = mockBean.createClass();
		
		Object beanA = clazz.newInstance();
		set(beanA, "prop1", 100);
		
		AnnotationReader ar = new AnnotationReader();
		
		ContainerIgnore container = ar.readingAnnotationsTo(clazz, ContainerIgnore.class);
		
		assertTrue(container.getProperties().isEmpty());
		
	}

	@Test
	public void testSemOIgnore() throws Exception {
		mockBean.addProperty("prop1", int.class);
		clazz = mockBean.createClass();
		
		Object beanA = clazz.newInstance();
		set(beanA, "prop1", 100);
		
		AnnotationReader ar = new AnnotationReader();
		
		ContainerIgnore container = ar.readingAnnotationsTo(clazz, ContainerIgnore.class);
		
		assertFalse(container.getProperties().isEmpty());
		assertEquals("prop1", container.getPropertyDescriptor("prop1").getName());
		
	}
	
	@Test
	public void testIgnorandoUmObjeto() throws Exception {
		mockBean.addProperty("prop1", int.class);
		mockBean.addAnnotation("prop1", IgnoreInComparison.class);
		mockBean.addProperty("prop2", int.class);
		mockBean.addAnnotation("prop1", IgnoreInComparison.class);

		clazz = mockBean.createClass();
				
		AnnotationReader ar = new AnnotationReader();
		
		ContainerIgnore container = ar.readingAnnotationsTo(clazz, ContainerIgnore.class);
		
		assertFalse(container.getProperties().isEmpty());
		assertEquals(1, container.getProperties().size());
		assertEquals("prop2", container.getPropertyDescriptor("prop2").getName());

	}

	@Test
	public void testIgnorandoUmObjetoeRetronaDois() throws Exception {
		mockBean.addProperty("prop1", int.class);
		mockBean.addAnnotation("prop1", IgnoreInComparison.class);
		mockBean.addProperty("prop2", int.class);
		mockBean.addProperty("prop3", int.class);
		mockBean.addAnnotation("prop1", IgnoreInComparison.class);

		clazz = mockBean.createClass();
				
		AnnotationReader ar = new AnnotationReader();
		
		ContainerIgnore container = ar.readingAnnotationsTo(clazz, ContainerIgnore.class);
		
		assertFalse(container.getProperties().isEmpty());
		assertEquals(2, container.getProperties().size());
		assertEquals("prop2", container.getPropertyDescriptor("prop2").getName());
		assertEquals("prop3", container.getPropertyDescriptor("prop3").getName());

	}


}
