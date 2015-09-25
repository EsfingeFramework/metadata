package org.esfinge.metadata.validate;

import org.esfinge.metadata.validate.AnnotationValidationException;
import org.esfinge.metadata.validate.MetadataValidator;
import org.junit.Test;

public class TestValidateNeedsToHave<Purchase> {
	
	//ValidateNeedsToHaveEnclosing
	@Transaction
	public class OrderProcessing1{
		@Logging
		public void registerPurchase(Purchase p){}
	}
	
	@Test
	public void needsToHaveEnclosing() throws AnnotationValidationException{
		MetadataValidator.validateMetadataOn(OrderProcessing1.class);
	}
	
	//ValidateNeedsToHaveNormal
	public class OrderProcessing2{
		@Transaction @Logging
		public void registerPurchase(Purchase p){}
	}
	
	@Test
	public void needsToHaveNormal() throws AnnotationValidationException{
		MetadataValidator.validateMetadataOn(OrderProcessing2.class);
	}
	
	//ValidateNeedsToHaveFail
	public class OrderProcessing3{
		@Logging
		public void registerPurchase(Purchase p){}
	}
	
	@Test(expected = AnnotationValidationException.class)
	public void needsToHaveFail() throws AnnotationValidationException{
		MetadataValidator.validateMetadataOn(OrderProcessing3.class);
	}
}