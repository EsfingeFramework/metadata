package net.sf.esfinge.metadata.properties;

import static net.sf.esfinge.classmock.ClassMockUtils.set;
import static org.junit.Assert.*;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.apache.commons.collections.functors.IfClosure;
import org.junit.Before;
import org.junit.Test;

import net.sf.esfinge.classmock.ClassMock;
import net.sf.esfinge.metadata.properties.containers.*;
import net.sf.esfinge.metadata.properties.elements.IgnoraInterno;
import net.sf.esfinge.metadata.properties.elements.IgnoreOneField;
import net.sf.esfinge.metadata.properties.elements.IgnoreOneFieldAndReturnTwo;
import net.sf.esfinge.metadata.properties.elements.PropertyEmpty;
import net.sf.esfinge.metadata.properties.elements.PropertyInClass;
import net.sf.esfinge.metadata.properties.elements.PropertyInField;
import net.sf.esfinge.metadata.properties.elements.PropertyInMethod;
import net.sf.esfinge.metadata.properties.elements.WinouthIgnore;
import net.sf.esfinge.metadata.AnnotationFinder;
import net.sf.esfinge.metadata.AnnotationReader;
import net.sf.esfinge.metadata.locate.AnnotationLocator;
import net.sf.esfinge.metadata.properties.annotation.IgnoreInComparison;
import net.sf.esfinge.metadata.properties.annotation.IgnoreInc;

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
