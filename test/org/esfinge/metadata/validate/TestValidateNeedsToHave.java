package org.esfinge.metadata.validate;

import org.junit.Test;

public class TestValidateNeedsToHave {
	
	@Transaction
	public class ValidateNeedsToHaveEnclosing{
		@Logging
		public void method(){}
	}
	
	@Test
	public void needsToHaveEnclosing() throws AnnotationValidationException{
		MetadataValidator.validateMetadataOn(ValidateNeedsToHaveEnclosing.class);
	}
	
	
	public class ValidateNeedsToHaveNormal{
		@Transaction @Logging
		public void method(){}
	}
	
	@Test
	public void needsToHaveNormal() throws AnnotationValidationException{
		MetadataValidator.validateMetadataOn(ValidateNeedsToHaveNormal.class);
	}
	
	public class ValidateNeedsToHaveFail{
		@Logging
		public void method(){}
	}
	
	@Test(expected = AnnotationValidationException.class)
	public void needsToHaveFail() throws AnnotationValidationException{
		MetadataValidator.validateMetadataOn(ValidateNeedsToHaveFail.class);
	}
}