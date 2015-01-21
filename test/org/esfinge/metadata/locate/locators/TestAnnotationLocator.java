package org.esfinge.metadata.locate.locators;

import static org.junit.Assert.*;

import java.lang.annotation.Annotation;

import org.esfinge.metadata.AnnotationFinder;
import org.esfinge.metadata.locate.annotations.*;
import org.esfinge.metadata.locate.classes.ForTestAnnotationLocator;
import org.esfinge.metadata.locate.classes.ForTestAnnotationLocatorWithoutAnnotations;
import org.junit.Ignore;
import org.junit.Test;

public class TestAnnotationLocator {
	
	@Test
	public void locateRegularMetadataOnClass() {
		Annotation an = AnnotationFinder.findAnnotation(ForTestAnnotationLocator.class,FindMeClass.class);		
		assertNotNull(an);
		assertTrue(an instanceof FindMeClass);
	}
	
	@Test
	public void locateRegularMetadataOnMethod() throws NoSuchMethodException {
		Annotation an = AnnotationFinder.findAnnotation(ForTestAnnotationLocator.class.getMethod("method", null),FindMeMethod.class);		
		assertNotNull(an);
		assertTrue(an instanceof FindMeMethod);
	}

	@Test
	public void locateRegularMetadataOnField() throws NoSuchFieldException {
		Annotation an = AnnotationFinder.findAnnotation(ForTestAnnotationLocator.class.getField("attribute"),FindMeAttribute.class);		
		assertNotNull(an);
		assertTrue(an instanceof FindMeAttribute);
	}
	
	@Test
	public void locateRegularMetadataOnMethodLevel2() throws NoSuchMethodException {
		Annotation an = AnnotationFinder.findAnnotation(ForTestAnnotationLocator.class.getMethod("method2", null),FindMeMethod.class);		
		assertNotNull(an);
		assertTrue(an instanceof FindMeMethod);
	}
	
	

	@Test
	public void doNotLocateRegularMetadataOnClass() {
		Annotation an = AnnotationFinder.findAnnotation(ForTestAnnotationLocatorWithoutAnnotations.class,FindMeClass.class);		
		assertNull(an);
		assertFalse(an instanceof FindMeClass);
	}
	
	@Test 
	public void doNotLocateRegularMetadataOnMethod() throws NoSuchMethodException {
		Annotation an = AnnotationFinder.findAnnotation(ForTestAnnotationLocatorWithoutAnnotations.class.getMethod("method", null),FindMeMethod.class);		
		assertNull(an);
		assertFalse(an instanceof FindMeMethod);
	}

	@Test 
	public void doNotLocateRegularMetadataOnField() throws NoSuchFieldException {
		Annotation an = AnnotationFinder.findAnnotation(ForTestAnnotationLocatorWithoutAnnotations.class.getField("attribute"),FindMeAttribute.class);		
		assertNull(an);
		assertFalse(an instanceof FindMeAttribute);
	}
	
	@Test 
	public void doNotLocateRegularMetadataOnMethodLevel2() throws NoSuchMethodException {
		Annotation an = AnnotationFinder.findAnnotation(ForTestAnnotationLocatorWithoutAnnotations.class.getMethod("method2", null),FindMeMethod.class);		
		assertNull(an);
		assertFalse(an instanceof FindMeMethod);
	}	
	
}
