package net.sf.esfinge.metadata.properties;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import net.sf.esfinge.metadata.AnnotationReader;
import net.sf.esfinge.metadata.container.MetadataRepository;
import net.sf.esfinge.metadata.properties.containers.ContainerDescriptorWithContainAnnotation;
import net.sf.esfinge.metadata.properties.elements.PropertyInClass;
import net.sf.esfinge.metadata.properties.elements.PropertyInField;
import net.sf.esfinge.metadata.properties.elements.PropertyInMethod;

public class PropiertiesInternData {
	

	@Before
	public void destroyAnnotation() throws Exception
	{
		MetadataRepository.destroyRepository();
	}
	
	@Test
	public void testInClass() throws Exception {

		AnnotationReader ar = new AnnotationReader();
		ContainerDescriptorWithContainAnnotation container= new ContainerDescriptorWithContainAnnotation();
		container = ar.readingAnnotationsTo(PropertyInClass.class, container.getClass());
		
		
		//fail("verificar o comportamento da classe");
		assertEquals(3, container.getProperties().size());
		assertFalse(container.getPropertyDescriptor("prop1").isAnnoted());
		

	}
	
	
	@Test
	public void testInField() throws Exception {
		AnnotationReader ar = new AnnotationReader();
		ContainerDescriptorWithContainAnnotation container= new ContainerDescriptorWithContainAnnotation();
		container = ar.readingAnnotationsTo(PropertyInField.class, container.getClass());
		
		//fail("verificar o comportamento da classe");
		assertFalse(container.getProperties().isEmpty());
		assertEquals(6, container.getProperties().size());
		assertTrue("FALSO",container.getPropertyDescriptor("prop2").isAnnoted());
	}

	@Test
	public void testInMethod() throws Exception {
		AnnotationReader ar = new AnnotationReader();
		ContainerDescriptorWithContainAnnotation container= new ContainerDescriptorWithContainAnnotation();
		container = ar.readingAnnotationsTo(PropertyInMethod.class, container.getClass());
		//fail("verificar o comportamento da classe");
		assertFalse(container.getProperties().isEmpty());
		assertEquals(6, container.getProperties().size());
		//assertTrue("FALSO",container.getPropertyDescriptor("prop2").isAnnoted());
	}


}
