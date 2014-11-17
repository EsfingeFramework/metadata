package org.esfinge.metadata;

import static org.junit.Assert.*;
import java.lang.annotation.Annotation;
import org.esfinge.metadata.AnnotationFinder;
import org.junit.Test;

public class TestRegularLocator {

	@FindMeClass
	public class ForTest {

		@FindMeAttribute
		public String attribute;

		// se o acesso for privado ou protegido, o metodo n encontra a anotacao

		@FindMeMethod
		public void method() {

		}
	}

	public class ForTestWithouAnnottations {
		@FindMeMethod
		public String attribute;

		@FindMeClass
		@FindMeAttribute
		public void method() {

		}
	}
	
	@Test
	public void doNotLocateRegularMetadataOnClass() {
		Annotation an = AnnotationFinder.findAnnotation(ForTestWithouAnnottations.class,
				FindMeClass.class);
		assertNull(an);
		assertFalse(an instanceof FindMeClass);
	}
	
	@Test
	public void doNotLocateRegularMetadataOnMethod() {
		Annotation an = AnnotationFinder.findAnnotation(ForTestWithouAnnottations.class,
				FindMeMethod.class);
		assertNull(an);
		assertFalse(an instanceof FindMeMethod);
	}
	
	@Test
	public void doNotLocateRegularMetadataOnField() {
		Annotation an = AnnotationFinder.findAnnotation(ForTestWithouAnnottations.class,
				FindMeAttribute.class);
		assertNull(an);
		assertFalse(an instanceof FindMeAttribute);
	}

	@Test
	public void locateRegularMetadataOnMethod() throws NoSuchMethodException, SecurityException {
		Annotation an = AnnotationFinder.findAnnotation(
				ForTest.class.getMethod("method", null), FindMeMethod.class);
		assertNotNull(an);
		assertTrue(an instanceof FindMeMethod);
	}

	@Test
	public void locateRegularMetadataOnField() throws NoSuchMethodException, SecurityException, NoSuchFieldException {
		Annotation an = AnnotationFinder.findAnnotation(
				ForTest.class.getField("attribute"), FindMeAttribute.class);
		assertNotNull(an);
		assertTrue(an instanceof FindMeAttribute);
	}

	@Test
	public void locateRegularMetadataOnClass() {
		Annotation an = AnnotationFinder.findAnnotation(ForTest.class,
				FindMeClass.class);
		assertNotNull(an);
		assertTrue(an instanceof FindMeClass);
	}

	@Test
	public void locateAnotationOnMethodDefinedOnClass()	throws NoSuchMethodException, SecurityException {
		Annotation an = AnnotationFinder.findAnnotation(
				ForTest.class.getMethod("method", null), FindMeClass.class);
		assertNotNull(an);
		assertTrue(an instanceof FindMeClass);
	}

}
