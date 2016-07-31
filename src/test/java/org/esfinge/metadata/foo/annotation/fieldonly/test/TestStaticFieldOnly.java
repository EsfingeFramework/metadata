package org.esfinge.metadata.foo.annotation.fieldonly.test;

import static org.junit.Assert.*;

import org.esfinge.metadata.foo.annotation.fieldonly.StaticFieldOnly;
import org.esfinge.metadata.foo.annotation.test.Person;
import org.esfinge.metadata.foo.annotation.test.PersonWithError;
import org.esfinge.metadata.foo.validator.Validator;
import org.esfinge.metadata.foo.validator.ValidatorInterface;
import org.esfinge.metadata.foo.validator.implementation.ValidatorFieldOnly;
import org.junit.Before;
import org.junit.Test;

public class TestStaticFieldOnly {
	
	private Validator validator;
	
	@Before
	public void init(){
		ValidatorInterface vi = new ValidatorFieldOnly(StaticFieldOnly.class, "static");			
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

}
