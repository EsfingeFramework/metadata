package org.esfinge.metadata.locate.locators;

import static org.junit.Assert.*;
import java.lang.annotation.Annotation;
import org.esfinge.metadata.AnnotationFinder;
import org.esfinge.metadata.locate.annotations.FindMeClass;
import org.esfinge.metadata.locate.annotations.FindMeMethod;
import org.esfinge.metadata.locate.annotations.FindMePackage;
import org.esfinge.metadata.locate.classes.*;
import org.junit.Ignore;
import org.junit.Test;

public class TestFatherLocator {

	@Test 
	public void locateAnotationOnFieldDefinedOnClass() throws NoSuchFieldException{
		Annotation an = AnnotationFinder.findAnnotation(ForTestFatherLocator.class.getField("attribute"),	FindMeClass.class);
		assertNotNull(an);
		assertTrue(an instanceof FindMeClass);
	}

	@Test 
	public void locateAnotationOnClassDefinedOnPackage() {
		Annotation an = AnnotationFinder.findAnnotation(ForTestFatherLocator.class,	FindMePackage.class);
		assertNotNull(an);
		assertTrue(an instanceof FindMePackage);
	}

	@Test 
	public void locateAnotationOnMethodDefinedOnPackage() throws NoSuchMethodException {
		Annotation an = AnnotationFinder.findAnnotation(ForTestFatherLocator.class.getMethod("method", null),	FindMePackage.class);
		assertNotNull(an);
		assertTrue(an instanceof FindMePackage);		
	}
	
	@Test 
	public void locateAnotationOnFieldDefinedOnPackage() throws NoSuchFieldException {
		Annotation an = AnnotationFinder.findAnnotation(ForTestFatherLocator.class.getField("attribute"),	FindMePackage.class);
		assertNotNull(an);
		assertTrue(an instanceof FindMePackage);		
	}

	@Test 
	public void locateAnotationOnMethodDefinedOnClass() throws NoSuchMethodException {
		Annotation an = AnnotationFinder.findAnnotation(ForTestFatherLocator.class.getMethod("method", null),	FindMeClass.class);
		assertNotNull(an);
		assertTrue(an instanceof FindMeClass);
	}
	
	@Test 
	public void doNotLocateAnotationOnFieldDefinedOnClass()throws NoSuchFieldException{
		Annotation an = AnnotationFinder.findAnnotation(ForTestFatherLocatorWithoutAnnotations.class.getField("attribute"),	FindMeClass.class);
		assertNull(an);
		assertFalse(an instanceof FindMeClass);
	}


	@Test 
	public void doNotLocateAnotationOnClassDefinedOnPackage() {
		Annotation an = AnnotationFinder.findAnnotation(ForTestFatherLocatorWithoutAnnotations.class, FindMePackage.class);
		assertNull(an);
		assertFalse(an instanceof FindMePackage);
	}
	
	@Test 
	public void doNotLocateAnotationOnMethodDefinedOnPackage() throws NoSuchMethodException {
		Annotation an = AnnotationFinder.findAnnotation(ForTestFatherLocatorWithoutAnnotations.class.getMethod("method", null),	FindMePackage.class);
		assertNull(an);
		assertFalse(an instanceof FindMePackage);		
	}
	
	@Test 
	public void doNotLocateAnotationOnFieldDefinedOnPackage() throws NoSuchFieldException {
		Annotation an = AnnotationFinder.findAnnotation(ForTestFatherLocatorWithoutAnnotations.class.getField("attribute"),	FindMePackage.class);
		assertNull(an);
		assertFalse(an instanceof FindMePackage);		
	}

	@Test 
	public void locateAnotationOnFieldDefinedOnMethod() throws NoSuchFieldException {
		Annotation an = AnnotationFinder.findAnnotation(ForTestFatherLocator.class.getField("attribute"),	FindMeMethod.class);
		assertNotNull(an);
		assertTrue(an instanceof FindMeMethod);
	}
	
	@Test 
	public void doNotLocateAnotationOnFieldDefinedOnMethod()throws NoSuchFieldException {
		Annotation an = AnnotationFinder.findAnnotation(ForTestFatherLocatorWithoutAnnotations.class.getField("attribute"),	FindMeMethod.class);
		assertNull(an);
		assertFalse(an instanceof FindMeMethod);
	}

}
