package org.esfinge.metadata;
import static org.junit.Assert.*;

import java.lang.annotation.Annotation;

import org.esfinge.metadata.AnnotationFinder;
import org.junit.Test;


public class TestMetadataLocator {
	
	@FindMeClass
	public class ForTest{
		
		@FindMeAttribute
		private String attribute;
		
		
		@FindMeMethod
		public void method(){
			
		}
	}	
		
	@Test
	public void locateRegularMetadataClass() {
		Annotation an = AnnotationFinder.findAnnotation(ForTest.class, FindMeClass.class);
		assertNotNull(an);
		assertTrue(an instanceof FindMeClass);
	}
	
	@Test
	public void locateRegularMetadataMethod() {
		Annotation an = AnnotationFinder.findAnnotation(ForTest.class, FindMeMethod.class);
		assertNotNull(an);
		//assertTrue(an instanceof FindMeMethod);
	}

}
