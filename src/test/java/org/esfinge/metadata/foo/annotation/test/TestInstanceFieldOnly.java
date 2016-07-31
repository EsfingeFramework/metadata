package org.esfinge.metadata.foo.annotation.test;

import static org.junit.Assert.*;

import org.esfinge.metadata.foo.validator.ValidateInstanceFieldOnly;
import org.junit.Test;

public class TestInstanceFieldOnly {
	
	@Test
	public void testWithSuccess() throws Exception {
		Person p = new Person("Jason", "32198732143", 15);
		
		ValidateInstanceFieldOnly validator = new ValidateInstanceFieldOnly();		
		boolean validated = validator.validateAnnotationInObject(p);
			
		assertTrue(validated);
	}
	
	@Test(expected = Exception.class)
	public void testWithError() throws Exception {
		PersonWithError p = new PersonWithError("Piper", "65345186593", 13);
		
		ValidateInstanceFieldOnly validator = new ValidateInstanceFieldOnly();	
		
		validator.validateAnnotationInObject(p);
	}

}
