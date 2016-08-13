package org.esfinge.metadata.validate.field.test;

import static org.junit.Assert.assertTrue;

import org.esfinge.metadata.AnnotationValidationException;
import org.esfinge.metadata.validate.MetadataValidator;
import org.junit.Test;

public class TestTransientFieldOnly {
	
	@Test
	public void testWithSuccess() throws Exception {		
		MetadataValidator.validateMetadataOn(Person.class);
		assertTrue(true);
	}
	
	@Test(expected = AnnotationValidationException.class)
	public void testWithError() throws AnnotationValidationException {				
		MetadataValidator.validateMetadataOn(PersonWithErrorTransientFieldOnly.class);
	}

}
