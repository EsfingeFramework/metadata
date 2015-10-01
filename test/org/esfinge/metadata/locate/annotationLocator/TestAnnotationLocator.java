package org.esfinge.metadata.locate.annotationLocator;

import static org.junit.Assert.*;

import java.lang.annotation.Annotation;

import org.esfinge.metadata.AnnotationFinder;
import org.esfinge.metadata.locate.annotations.*;
import org.junit.Test;

public class TestAnnotationLocator {

	// CT01
	public class class01 {		
		public void method() {

		}
	}

	@Test 
	public void CT01() throws NoSuchMethodException {
		Annotation an = AnnotationFinder.findAnnotation(class01.class.getMethod("method", null), Transaction.class);
		assertNull(an);
		assertFalse(an instanceof Transaction);
	}
	
	
	// CT02
	public class class02 {
		@Administration
		public void method() {

		}
	}

	@Test
	public void CT02() throws NoSuchMethodException {
		Annotation an = AnnotationFinder.findAnnotation(class02.class.getMethod("method", null), Transaction.class);
		assertNotNull(an);
		assertTrue(an instanceof Transaction);
	}
	
	// CT03
	@Administration
	public class class03 {
		public void method() {

		}
	}

	@Test
	public void CT03() throws NoSuchMethodException {
		Annotation an = AnnotationFinder.findAnnotation(class03.class.getMethod("method", null), Transaction.class);
		assertNotNull(an);
		assertTrue(an instanceof Transaction);
	}
	

	/*
	 * @Test public void locateRegularMetadataOnMethod() throws
	 * NoSuchMethodException { Annotation an =
	 * AnnotationFinder.findAnnotation(ForTestAnnotationLocator
	 * .class.getMethod("method", null),FindMeMethod.class); assertNotNull(an);
	 * assertTrue(an instanceof FindMeMethod); }
	 * 
	 * @Test public void locateRegularMetadataOnField() throws
	 * NoSuchFieldException { Annotation an =
	 * AnnotationFinder.findAnnotation(ForTestAnnotationLocator
	 * .class.getField("attribute"),FindMeAttribute.class); assertNotNull(an);
	 * assertTrue(an instanceof FindMeAttribute); }
	 * 
	 * @Test public void doNotLocateRegularMetadataOnClass() { Annotation an =
	 * AnnotationFinder
	 * .findAnnotation(ForTestAnnotationLocatorWithoutAnnotations
	 * .class,FindMeClass.class); assertNull(an); assertFalse(an instanceof
	 * FindMeClass); }
	 * 
	 * @Test public void doNotLocateRegularMetadataOnMethod() throws
	 * NoSuchMethodException { Annotation an =
	 * AnnotationFinder.findAnnotation(ForTestAnnotationLocatorWithoutAnnotations
	 * .class.getMethod("method", null),FindMeMethod.class); assertNull(an);
	 * assertFalse(an instanceof FindMeMethod); }
	 * 
	 * @Test public void doNotLocateRegularMetadataOnField() throws
	 * NoSuchFieldException { Annotation an =
	 * AnnotationFinder.findAnnotation(ForTestAnnotationLocatorWithoutAnnotations
	 * .class.getField("attribute"),FindMeAttribute.class); assertNull(an);
	 * assertFalse(an instanceof FindMeAttribute); }
	 * 
	 * @Test public void doNotLocateRegularMetadataOnMethodLevel2() throws
	 * NoSuchMethodException { Annotation an =
	 * AnnotationFinder.findAnnotation(ForTestAnnotationLocatorWithoutAnnotations
	 * .class.getMethod("method2", null),FindMeMethod.class); assertNull(an);
	 * assertFalse(an instanceof FindMeMethod); }
	 */
}
