package org.esfinge.metadata;
import static org.junit.Assert.*;

import java.lang.annotation.Annotation;

import org.esfinge.metadata.AnnotationFinder;
import org.junit.Test;


public class TestMetadataLocator {
	
	@FindMeClass
	public class ForTest{
		
		@FindMeAttribute
		public String attribute;
		
		//se o acesso for privado ou protegido, o metodo n encontra a anotação
		
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
	public void locateFatherMetadataMethod() throws NoSuchMethodException, SecurityException {
		Annotation an = AnnotationFinder.findAnnotation(ForTest.class.getMethod("method", null), FindMeMethod.class);
		assertNotNull(an);
		assertTrue(an instanceof FindMeMethod);
	}
	
	@Test
	public void locateFatherMetadataField() throws NoSuchMethodException, SecurityException, NoSuchFieldException {
		Annotation an = AnnotationFinder.findAnnotation(ForTest.class.getField("attribute"), FindMeAttribute.class);
		assertNotNull(an);
		assertTrue(an instanceof FindMeAttribute);
	}


}
