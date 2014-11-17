package org.esfinge.metadata;


import static org.junit.Assert.*;
import java.lang.annotation.Annotation;
import org.esfinge.metadata.AnnotationFinder;
import org.junit.Test;

public class TestFatherLocator {

	@FindMePackage
	public class ForTest {

		@FindMeClass
		@FindMeMethod
		@FindMePackage
		public String attribute;

		// se o acesso for privado ou protegido, o metodo n encontra a anotacao

		@FindMeClass
		@FindMePackage
		public void method() {

		}
	}

	public class ForTestWithouAnnottations {
		public String attribute;

		public void method() {

		}
	}

	@Test
	public void locateAnotationOnMethodDefinedOnClass() {
		Annotation an = AnnotationFinder.findAnnotation(ForTest.class,	FindMeClass.class);
		assertNotNull(an);
		assertTrue(an instanceof FindMeClass);		
	}

/*
	@Test
	public void locateAnotationOnFieldDefinedOnClass() {
	
	}

*/
	@Test
	public void locateAnotationOnClassDefinedOnPackage() {
		Annotation an = AnnotationFinder.findAnnotation(ForTest.class,	FindMePackage.class);
		assertNotNull(an);
		assertTrue(an instanceof FindMePackage);
	}
/*	
	@Test
	public void locateAnotationOnMethodDefinedOnPackage() {

		
	}
	
	@Test
	public void locateAnotationOnFieldDefinedOnPackage() {
		
	}
*/
	@Test
	public void doNotLocateAnotationOnMethodDefinedOnClass() {
		Annotation an = AnnotationFinder.findAnnotation(ForTest.class,	FindMeClass.class);
		assertNull(an);
		assertFalse(an instanceof FindMeClass);
	}
	
	@Test
	public void doNotLocateAnotationOnFieldDefinedOnClass() {
		
	}

	@Test
	public void doNotLocateAnotationOnClassDefinedOnPackage() {
		Annotation an = AnnotationFinder.findAnnotation(ForTest.class,	FindMePackage.class);
		assertNull(an);
		assertFalse(an instanceof FindMePackage);
	}
	
	@Test
	public void doNotLocateAnotationOnMethodDefinedOnPackage() {
		
	}
	
	@Test
	public void doNotLocateAnotationOnFieldDefinedOnPackage() {
		
	}

	@Test
	public void locateAnotationOnFieldDefinedOnMethod() {

	}
	
	@Test
	public void doNotLocateAnotationOnFieldDefinedOnMethod() {

	}

}
