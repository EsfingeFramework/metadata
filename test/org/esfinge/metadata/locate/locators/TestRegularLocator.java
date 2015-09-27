package org.esfinge.metadata.locate.locators;

import static org.junit.Assert.*;
import java.lang.annotation.Annotation;
import org.esfinge.metadata.AnnotationFinder;
import org.esfinge.metadata.locate.annotations.*;
import org.esfinge.metadata.locate.classes.*;
import org.junit.Test;

public class TestRegularLocator {
	@Test
	public void doNotLocateRegularMetadataOnClass() {
		Annotation an = AnnotationFinder.findAnnotation(ForTestRegularLocatorWithoutAnnotations.class,
				Transaction.class);
		assertNull(an);
		assertFalse(an instanceof Transaction);
	}
	
	@Test
	public void doNotLocateRegularMetadataOnMethod() {
		Annotation an = AnnotationFinder.findAnnotation(ForTestRegularLocatorWithoutAnnotations.class,
				FindMeMethod.class);
		assertNull(an);
		assertFalse(an instanceof FindMeMethod);
	}
	
	@Test
	public void doNotLocateRegularMetadataOnField() {
		Annotation an = AnnotationFinder.findAnnotation(ForTestRegularLocatorWithoutAnnotations.class,
				FindMeAttribute.class);
		assertNull(an);
		assertFalse(an instanceof FindMeAttribute);
	}

	@Test
	public void locateRegularMetadataOnMethod() throws NoSuchMethodException, SecurityException {
		Annotation an = AnnotationFinder.findAnnotation(
				ForTestRegularLocator.class.getMethod("method", null), FindMeMethod.class);
		assertNotNull(an);
		assertTrue(an instanceof FindMeMethod);
	}

	@Test
	public void locateRegularMetadataOnField() throws NoSuchMethodException, NoSuchFieldException {
		Annotation an = AnnotationFinder.findAnnotation(
				ForTestRegularLocator.class.getField("attribute"), FindMeAttribute.class);
		assertNotNull(an);
		assertTrue(an instanceof FindMeAttribute);
	}

	@Test
	public void locateRegularMetadataOnClass() {
		Annotation an = AnnotationFinder.findAnnotation(ForTestRegularLocator.class,
				Transaction.class);
		assertNotNull(an);
		assertTrue(an instanceof Transaction);
	}
}
