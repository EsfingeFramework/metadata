package org.esfinge.metadata.validate.prohibits;

import org.esfinge.metadata.AnnotationValidationException;
import org.esfinge.metadata.validate.MetadataValidator;
import org.junit.Test;

public class TestValidateProhibits<Purchase> {

	// CT01
	public class OrderProcessing01 {
		@Init @Finalize
		public void registerPurchase(Purchase p) {
		}
	}

	@Test(expected = AnnotationValidationException.class)
	public void CT01() throws AnnotationValidationException {
		MetadataValidator.validateMetadataOn(OrderProcessing01.class);
	}

	// CT02	
	public class OrderProcessing02 {
		@Init 
		public void registerPurchase() {
		}
	}

	@Test 
	public void CT02() throws AnnotationValidationException {
		MetadataValidator.validateMetadataOn(OrderProcessing02.class);
	}
	
	// CT03
	@Finalize
	public class OrderProcessing03 {
		@Init
		public void registerPurchase(Purchase p) {
		}
	}

	@Test(expected = AnnotationValidationException.class)
	public void CT03() throws AnnotationValidationException {
		MetadataValidator.validateMetadataOn(OrderProcessing03.class);
	}

	
}
