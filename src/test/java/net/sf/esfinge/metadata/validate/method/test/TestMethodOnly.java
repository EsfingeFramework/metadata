package net.sf.esfinge.metadata.validate.method.test;

import net.sf.esfinge.metadata.AnnotationReadingException;
import org.junit.Test;

import net.sf.esfinge.metadata.AnnotationValidationException;
import net.sf.esfinge.metadata.validate.MetadataValidator;

public class TestMethodOnly {	
		
	@Test
	public void testWithSuccess() throws Exception {		
		MetadataValidator.validateMetadataOn(Person.class);
	}
		
	@Test(expected = AnnotationValidationException.class)
	public void testWithErrorPersonWithErrorFinalMethodOnly() throws AnnotationValidationException, AnnotationReadingException {
		MetadataValidator.validateMetadataOn(PersonWithErrorFinalMethodOnly.class);
	}
	
	@Test(expected = AnnotationValidationException.class)
	public void testWithErrorPersonWithErrorForbiddenMethodReturn() throws AnnotationValidationException, AnnotationReadingException {
		MetadataValidator.validateMetadataOn(PersonWithErrorForbiddenMethodReturn.class);
	}
	
	@Test(expected = AnnotationValidationException.class)
	public void testWithErrorPersonWithErrorInstanceMethodOnly() throws AnnotationValidationException, AnnotationReadingException {
		MetadataValidator.validateMetadataOn(PersonWithErrorInstanceMethodOnly.class);
	}
	
	@Test(expected = AnnotationValidationException.class)
	public void testWithErrorPersonWithErrorMethodNamingConvention() throws AnnotationValidationException, AnnotationReadingException {
		MetadataValidator.validateMetadataOn(PersonWithErrorMethodNamingConvention.class);
	}
	
	@Test(expected = AnnotationValidationException.class)
	public void testWithErrorPersonWithErrorMethodVisibilityForbidden() throws AnnotationValidationException, AnnotationReadingException {
		MetadataValidator.validateMetadataOn(PersonWithErrorMethodVisibilityForbidden.class);
	}
	
	@Test(expected = AnnotationValidationException.class)
	public void testWithErrorPersonWithErrorMethodVisibilityRequired() throws AnnotationValidationException, AnnotationReadingException {
		MetadataValidator.validateMetadataOn(PersonWithErrorMethodVisibilityRequired.class);
	}
	
	@Test(expected = AnnotationValidationException.class)
	public void testWithErrorPersonWithErrorNoParametersMethodOnly() throws AnnotationValidationException, AnnotationReadingException {
		MetadataValidator.validateMetadataOn(PersonWithErrorNoParametersMethodOnly.class);
	}
	
	@Test(expected = AnnotationValidationException.class)
	public void testWithErrorPersonWithErrorStaticMethodOnly() throws AnnotationValidationException, AnnotationReadingException {
		MetadataValidator.validateMetadataOn(PersonWithErrorStaticMethodOnly.class);
	}
	
	@Test(expected = AnnotationValidationException.class)
	public void testWithErrorPersonWithErrorStrictfpMethodOnly() throws AnnotationValidationException, AnnotationReadingException {
		MetadataValidator.validateMetadataOn(PersonWithErrorStrictfpMethodOnly.class);
	}
	
	@Test(expected = AnnotationValidationException.class)
	public void testWithErrorPersonWithErrorSynchronizedMethodOnly() throws AnnotationValidationException, AnnotationReadingException {
		MetadataValidator.validateMetadataOn(PersonWithErrorSynchronizedMethodOnly.class);
	}
	
	@Test(expected = AnnotationValidationException.class)
	public void testWithErrorPersonWithErrorValidMethodParameterTypes() throws AnnotationValidationException, AnnotationReadingException {
		MetadataValidator.validateMetadataOn(PersonWithErrorValidMethodParameterTypes.class);
	}
	
	@Test(expected = AnnotationValidationException.class)
	public void testWithErrorPersonWithErrorValidMethodReturn() throws AnnotationValidationException, AnnotationReadingException {
		MetadataValidator.validateMetadataOn(PersonWithErrorValidMethodReturn.class);
	}
	
	@Test(expected = AnnotationValidationException.class)
	public void testWithErrorPersonWithErrorValidNumberOfParameters() throws AnnotationValidationException, AnnotationReadingException {
		MetadataValidator.validateMetadataOn(PersonWithErrorValidNumberOfParameters.class);
	}

}
