package org.esfinge.metadata.locate.levelLocator;

import static org.junit.Assert.*;

import java.lang.annotation.Annotation;

import org.esfinge.metadata.AnnotationFinder;
import org.esfinge.metadata.locate.LevelLocator;
import org.esfinge.metadata.locate.annotations.FindMeMethod;
import org.esfinge.metadata.locate.annotations.FindMePackage;
import org.esfinge.metadata.locate.annotations.Transaction;
import org.junit.Test;

public class TestLevelLocator {
	private LevelLocator locator = new LevelLocator();
	
	
	@Test 
	public void locateAnotationOnMethodDefinedOnClass() throws NoSuchMethodException {
		Annotation an = AnnotationFinder.findAnnotation(ForTestLevelLocator.class.getMethod("method", null), Transaction.class);
		assertNotNull(an);
		assertTrue(an instanceof Transaction);
	}
	
	@Test 
	public void locateAnotationOnFieldDefinedOnClass() throws NoSuchFieldException{
		Annotation an = AnnotationFinder.findAnnotation(ForTestLevelLocator.class.getField("attribute"), Transaction.class);
		assertNotNull(an);
		assertTrue(an instanceof Transaction);
	}
	
	@Test 
	public void locateAnotationOnClassDefinedOnPackage() {
		Annotation an = AnnotationFinder.findAnnotation(ForTestLevelLocator.class,	FindMePackage.class);
		assertNotNull(an);
		assertTrue(an instanceof FindMePackage);
	}

	@Test 
	public void locateAnotationOnMethodDefinedOnPackage() throws NoSuchMethodException {
		Annotation an = AnnotationFinder.findAnnotation(ForTestLevelLocator.class.getMethod("method", null),	FindMePackage.class);
		assertNotNull(an);
		assertTrue(an instanceof FindMePackage);		
	}
	
	@Test 
	public void locateAnotationOnFieldDefinedOnPackage() throws NoSuchFieldException {
		Annotation an = AnnotationFinder.findAnnotation(ForTestLevelLocator.class.getField("attribute"),	FindMePackage.class);
		assertNotNull(an);
		assertTrue(an instanceof FindMePackage);		
	}


	@Test 
	public void doNotLocateAnotationOnFieldDefinedOnClass()throws NoSuchFieldException{
		Annotation an = AnnotationFinder.findAnnotation(ForTestLevelLocatorWithoutAnnotations.class.getField("attribute"),	Transaction.class);
		assertNull(an);
		assertFalse(an instanceof Transaction);
	}


	@Test 
	public void doNotLocateAnotationOnClassDefinedOnPackage() {
		Annotation an = AnnotationFinder.findAnnotation(ForTestLevelLocatorWithoutAnnotations.class, FindMePackage.class);
		assertNull(an);
		assertFalse(an instanceof FindMePackage);
	}
	
	@Test 
	public void doNotLocateAnotationOnMethodDefinedOnPackage() throws NoSuchMethodException {
		Annotation an = AnnotationFinder.findAnnotation(ForTestLevelLocatorWithoutAnnotations.class.getMethod("method", null),	FindMePackage.class);
		assertNull(an);
		assertFalse(an instanceof FindMePackage);		
	}
	
	@Test 
	public void doNotLocateAnotationOnFieldDefinedOnPackage() throws NoSuchFieldException {
		Annotation an = AnnotationFinder.findAnnotation(ForTestLevelLocatorWithoutAnnotations.class.getField("attribute"),	FindMePackage.class);
		assertNull(an);
		assertFalse(an instanceof FindMePackage);		
	}

	@Test 
	public void locateAnotationOnFieldDefinedOnMethod() throws NoSuchFieldException {
		Annotation an = AnnotationFinder.findAnnotation(ForTestLevelLocator.class.getField("attribute"),	FindMeMethod.class);
		assertNotNull(an);
		assertTrue(an instanceof FindMeMethod);
	}
	
	@Test 
	public void doNotLocateAnotationOnFieldDefinedOnMethod()throws NoSuchFieldException {
		Annotation an = AnnotationFinder.findAnnotation(ForTestLevelLocatorWithoutAnnotations.class.getField("attribute"),	FindMeMethod.class);
		assertNull(an);
		assertFalse(an instanceof FindMeMethod);
	}	
}
