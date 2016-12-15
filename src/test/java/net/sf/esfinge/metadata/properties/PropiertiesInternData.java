package net.sf.esfinge.metadata.properties;

import static org.junit.Assert.*;

import org.junit.Test;

import net.sf.esfinge.metadata.properties.containers.*;
import net.sf.esfinge.metadata.properties.elements.PropertyInClass;
import net.sf.esfinge.metadata.properties.elements.PropertyInField;
import net.sf.esfinge.metadata.properties.elements.PropertyInMethod;
import net.sf.esfinge.metadata.AnnotationReader;

public class PropiertiesInternData {
	

	
	@Test
	public void testInClass() throws Exception {

		
		
		
		AnnotationReader ar = new AnnotationReader();
		ContainerDescriptorWithContainAnnotation container= new ContainerDescriptorWithContainAnnotation();
		container = ar.readingAnnotationsTo(PropertyInClass.class, container.getClass());
		
		assertFalse(container.getProperties().isEmpty());
		assertEquals(1, container.getProperties().size());
		assertTrue("FALSO",container.getPropertyDescriptor("prop1").isAnnoted());
		


	}
	
	
	@Test
	public void testInField() throws Exception {
		AnnotationReader ar = new AnnotationReader();
		ContainerDescriptorWithContainAnnotation container= new ContainerDescriptorWithContainAnnotation();
		container = ar.readingAnnotationsTo(PropertyInField.class, container.getClass());
		
		assertFalse(container.getProperties().isEmpty());
		assertEquals(2, container.getProperties().size());
		assertTrue("FALSO",container.getPropertyDescriptor("prop2").isAnnoted());
	}

	@Test
	public void testInMethod() throws Exception {
		AnnotationReader ar = new AnnotationReader();
		ContainerDescriptorWithContainAnnotation container= new ContainerDescriptorWithContainAnnotation();
		container = ar.readingAnnotationsTo(PropertyInMethod.class, container.getClass());
		
		assertFalse(container.getProperties().isEmpty());
		assertEquals(2, container.getProperties().size());
		assertTrue("FALSO",container.getPropertyDescriptor("prop2").isAnnoted());
	}


}
