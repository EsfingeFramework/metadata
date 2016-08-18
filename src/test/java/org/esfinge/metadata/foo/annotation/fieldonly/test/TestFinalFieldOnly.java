package org.esfinge.metadata.foo.annotation.fieldonly.test;

import static org.junit.Assert.assertTrue;

import org.esfinge.metadata.AnnotationValidationException;
import org.esfinge.metadata.foo.annotation.test.Person;
import org.esfinge.metadata.validate.MetadataValidator;
import org.junit.Test;

public class TestFinalFieldOnly {
	
	@Test
	public void testWithSuccess() throws Exception {		
		MetadataValidator.validateMetadataOn(Person.class);
	}
	
	@Test(expected = AnnotationValidationException.class)
	public void testWithError() throws AnnotationValidationException {				
		MetadataValidator.validateMetadataOn(PersonWithErrorFinalFieldOnly.class);
	}

}
