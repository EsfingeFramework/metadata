package net.sf.esfinge.metadata.validate.method.test;

import org.junit.Test;

import net.sf.esfinge.metadata.AnnotationValidationException;
import net.sf.esfinge.metadata.validate.MetadataValidator;

public class TestMethodOnly {	
		
	@Test
	public void testWithSuccess() throws Exception {		
		MetadataValidator.validateMetadataOn(Person.class);
	}
		
	@Test(expected = AnnotationValidationException.class)
	public void testWithErrorPersonWithErrorFinalMethodOnly() throws AnnotationValidationException {				
		MetadataValidator.validateMetadataOn(PersonWithErrorFinalMethodOnly.class);
	}
	
	@Test(expected = AnnotationValidationException.class)
	public void testWithErrorPersonWithErrorForbiddenMethodReturn() throws AnnotationValidationException {				
		MetadataValidator.validateMetadataOn(PersonWithErrorForbiddenMethodReturn.class);
	}
	
	@Test(expected = AnnotationValidationException.class)
	public void testWithErrorPersonWithErrorInstanceMethodOnly() throws AnnotationValidationException {				
		MetadataValidator.validateMetadataOn(PersonWithErrorInstanceMethodOnly.class);
	}
	
	@Test(expected = AnnotationValidationException.class)
	public void testWithErrorPersonWithErrorMethodNamingConvention() throws AnnotationValidationException {				
		MetadataValidator.validateMetadataOn(PersonWithErrorMethodNamingConvention.class);
	}
	
	@Test(expected = AnnotationValidationException.class)
	public void testWithErrorPersonWithErrorMethodVisibilityForbidden() throws AnnotationValidationException {				
		MetadataValidator.validateMetadataOn(PersonWithErrorMethodVisibilityForbidden.class);
	}
	
	@Test(expected = AnnotationValidationException.class)
	public void testWithErrorPersonWithErrorMethodVisibilityRequired() throws AnnotationValidationException {				
		MetadataValidator.validateMetadataOn(PersonWithErrorMethodVisibilityRequired.class);
	}
	
	@Test(expected = AnnotationValidationException.class)
	public void testWithErrorPersonWithErrorNoParametersMethodOnly() throws AnnotationValidationException {				
		MetadataValidator.validateMetadataOn(PersonWithErrorNoParametersMethodOnly.class);
	}
	
	@Test(expected = AnnotationValidationException.class)
	public void testWithErrorPersonWithErrorStaticMethodOnly() throws AnnotationValidationException {				
		MetadataValidator.validateMetadataOn(PersonWithErrorStaticMethodOnly.class);
	}
	
	@Test(expected = AnnotationValidationException.class)
	public void testWithErrorPersonWithErrorStrictfpMethodOnly() throws AnnotationValidationException {				
		MetadataValidator.validateMetadataOn(PersonWithErrorStrictfpMethodOnly.class);
	}
	
	@Test(expected = AnnotationValidationException.class)
	public void testWithErrorPersonWithErrorSynchronizedMethodOnly() throws AnnotationValidationException {				
		MetadataValidator.validateMetadataOn(PersonWithErrorSynchronizedMethodOnly.class);
	}
	
	@Test(expected = AnnotationValidationException.class)
	public void testWithErrorPersonWithErrorValidMethodParameterTypes() throws AnnotationValidationException {				
		MetadataValidator.validateMetadataOn(PersonWithErrorValidMethodParameterTypes.class);
	}
	
	@Test(expected = AnnotationValidationException.class)
	public void testWithErrorPersonWithErrorValidMethodReturn() throws AnnotationValidationException {				
		MetadataValidator.validateMetadataOn(PersonWithErrorValidMethodReturn.class);
	}
	
	@Test(expected = AnnotationValidationException.class)
	public void testWithErrorPersonWithErrorValidNumberOfParameters() throws AnnotationValidationException {				
		MetadataValidator.validateMetadataOn(PersonWithErrorValidNumberOfParameters.class);
	}

}
