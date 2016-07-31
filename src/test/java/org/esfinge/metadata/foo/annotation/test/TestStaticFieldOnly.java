package org.esfinge.metadata.foo.annotation.test;

import static org.junit.Assert.*;

import org.esfinge.metadata.AnnotationValidationException;
import org.esfinge.metadata.foo.annotation.ValidateStaticFieldOnly;
import org.junit.Test;

public class TestStaticFieldOnly {
	
	@Test
	public void testWithSuccess() throws Exception {
		Person p = new Person("Jason", "32198732143", 15);
		
		boolean validated = ValidateStaticFieldOnly.validateStaticFieldOnly(p);
			
		assertTrue(validated);
	}
	
	@Test(expected = Exception.class)
	public void testWithError() throws Exception {
		PersonWithError p = new PersonWithError("Piper", "65345186593", 13);
		
		ValidateStaticFieldOnly.validateStaticFieldOnly(p);
	}

}
