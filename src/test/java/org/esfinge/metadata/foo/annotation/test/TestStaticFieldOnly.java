package org.esfinge.metadata.foo.annotation.test;

import static org.junit.Assert.*;

import org.esfinge.metadata.foo.annotation.StaticFieldOnly;
import org.esfinge.metadata.foo.validator.Validator;
import org.esfinge.metadata.foo.validator.ValidatorInterface;
import org.esfinge.metadata.foo.validator.implementation.ValidatorSpecificFieldOnly;
import org.junit.Before;
import org.junit.Test;

public class TestStaticFieldOnly {
	
	private Validator validator;
	
	@Before
	public void init(){
		ValidatorInterface vi = new ValidatorSpecificFieldOnly(StaticFieldOnly.class, "static");			
		validator = new Validator(vi);
	}
	
	@Test
	public void testWithSuccess() throws Exception {
		Person p = new Person("Jason", "32198732143", 15);
		boolean validated = validator.validateAnnotationInObject(p);			
		assertTrue(validated);
	}
	
	@Test(expected = Exception.class)
	public void testWithError() throws Exception {
		PersonWithError p = new PersonWithError("Piper", "65345186593", 13);
		validator.validateAnnotationInObject(p);
	}
	
	
//	@Test
//	public void testWithSuccess() throws Exception {
//		Person p = new Person("Jason", "32198732143", 15);
//		
//		Validator validator = new Validator(new ValidatorStaticFieldOnly());		
//		boolean validated = validator.validateAnnotationInObject(p);
//			
//		assertTrue(validated);
//	}
//	
//	@Test(expected = Exception.class)
//	public void testWithError() throws Exception {
//		PersonWithError p = new PersonWithError("Piper", "65345186593", 13);
//		
//		Validator validator = new Validator(new ValidatorStaticFieldOnly());	
//		validator.validateAnnotationInObject(p);
//	}

}
