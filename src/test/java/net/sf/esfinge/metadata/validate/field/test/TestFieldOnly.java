package net.sf.esfinge.metadata.validate.field.test;

import net.sf.esfinge.metadata.AnnotationReadingException;
import org.junit.Test;

import net.sf.esfinge.metadata.AnnotationValidationException;
import net.sf.esfinge.metadata.validate.MetadataValidator;

public class TestFieldOnly {	
	
	@Test
	public void testWithSuccess() throws Exception {		
		MetadataValidator.validateMetadataOn(Person.class);
	}
		
	@Test(expected = AnnotationValidationException.class)
	public void testWithErrorFieldVisibilityForbidden() throws AnnotationValidationException, AnnotationReadingException {
		MetadataValidator.validateMetadataOn(PersonWithErrorFieldVisibilityForbidden.class);
	}	
		
	@Test(expected = AnnotationValidationException.class)
	public void testWithErrorFieldVisibilityRequired() throws AnnotationValidationException, AnnotationReadingException {
		MetadataValidator.validateMetadataOn(PersonWithErrorFieldVisibilityRequired.class);
	}
		
	@Test(expected = AnnotationValidationException.class)
	public void testWithErrorFinalFieldOnly() throws AnnotationValidationException, AnnotationReadingException {
		MetadataValidator.validateMetadataOn(PersonWithErrorFinalFieldOnly.class);
	}
	
	@Test(expected = AnnotationValidationException.class)
	public void testWithErrorInstanceFieldOnly() throws AnnotationValidationException, AnnotationReadingException {
		MetadataValidator.validateMetadataOn(PersonWithErrorInstanceFieldOnly.class);
	}

	@Test(expected = AnnotationValidationException.class)
	public void testWithErrorStaticFieldOnly() throws AnnotationValidationException, AnnotationReadingException {
		MetadataValidator.validateMetadataOn(PersonWithErrorStaticFieldOnly.class);
	}
		
	@Test(expected = AnnotationValidationException.class)
	public void testWithErrorTransientFieldOnly() throws AnnotationValidationException, AnnotationReadingException {
		MetadataValidator.validateMetadataOn(PersonWithErrorTransientFieldOnly.class);
	}
		
	@Test(expected = AnnotationValidationException.class)
	public void testWithErrorValidFieldTypes() throws AnnotationValidationException, AnnotationReadingException {
		MetadataValidator.validateMetadataOn(PersonWithErrorValidFieldTypes.class);
	}
	
	@Test(expected = AnnotationValidationException.class)
	public void testWithErrorVolatileFieldOnly() throws AnnotationValidationException, AnnotationReadingException {
		MetadataValidator.validateMetadataOn(PersonWithErrorVolatileFieldOnly.class);
	}

}
