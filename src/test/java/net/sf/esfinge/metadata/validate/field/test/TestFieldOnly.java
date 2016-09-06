package net.sf.esfinge.metadata.validate.field.test;

import org.junit.Test;

import net.sf.esfinge.metadata.AnnotationValidationException;
import net.sf.esfinge.metadata.validate.MetadataValidator;

public class TestFieldOnly {	
	
	@Test
	public void testWithSuccess() throws Exception {		
		MetadataValidator.validateMetadataOn(Person.class);
	}
		
	@Test(expected = AnnotationValidationException.class)
	public void testWithErrorFieldVisibilityForbidden() throws AnnotationValidationException {				
		MetadataValidator.validateMetadataOn(PersonWithErrorFieldVisibilityForbidden.class);
	}	
		
	@Test(expected = AnnotationValidationException.class)
	public void testWithErrorFieldVisibilityRequired() throws AnnotationValidationException {				
		MetadataValidator.validateMetadataOn(PersonWithErrorFieldVisibilityRequired.class);
	}
		
	@Test(expected = AnnotationValidationException.class)
	public void testWithErrorFinalFieldOnly() throws AnnotationValidationException {				
		MetadataValidator.validateMetadataOn(PersonWithErrorFinalFieldOnly.class);
	}
	
	@Test(expected = AnnotationValidationException.class)
	public void testWithErrorInstanceFieldOnly() throws AnnotationValidationException {				
		MetadataValidator.validateMetadataOn(PersonWithErrorInstanceFieldOnly.class);
	}

	@Test(expected = AnnotationValidationException.class)
	public void testWithErrorStaticFieldOnly() throws AnnotationValidationException {				
		MetadataValidator.validateMetadataOn(PersonWithErrorStaticFieldOnly.class);
	}
		
	@Test(expected = AnnotationValidationException.class)
	public void testWithErrorTransientFieldOnly() throws AnnotationValidationException {				
		MetadataValidator.validateMetadataOn(PersonWithErrorTransientFieldOnly.class);
	}
		
	@Test(expected = AnnotationValidationException.class)
	public void testWithErrorValidFieldTypes() throws AnnotationValidationException {				
		MetadataValidator.validateMetadataOn(PersonWithErrorValidFieldTypes.class);
	}
	
	@Test(expected = AnnotationValidationException.class)
	public void testWithErrorVolatileFieldOnly() throws AnnotationValidationException {				
		MetadataValidator.validateMetadataOn(PersonWithErrorVolatileFieldOnly.class);
	}

}
