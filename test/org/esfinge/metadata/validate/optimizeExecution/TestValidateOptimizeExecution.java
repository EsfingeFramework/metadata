package org.esfinge.metadata.validate.optimizeExecution;

import org.esfinge.metadata.AnnotationValidationException;
import org.esfinge.metadata.validate.MetadataValidator;
import org.esfinge.metadata.validate.optimizeExecution.CT04.OrderProcessing04;
import org.esfinge.metadata.validate.optimizeExecution.CT07.OrderProcessing07;
import org.esfinge.metadata.validate.optimizeExecution.CT11.OrderProcessing11;
import org.esfinge.metadata.validate.optimizeExecution.CT14.OrderProcessing14;
import org.esfinge.metadata.validate.optimizeExecution.CT18.OrderProcessing18;
import org.esfinge.metadata.validate.optimizeExecution.CT21.OrderProcessing21;
import org.esfinge.metadata.validate.optimizeExecution.CT25.OrderProcessing25;
import org.esfinge.metadata.validate.optimizeExecution.CT28.OrderProcessing28;
import org.junit.Test;

public class TestValidateOptimizeExecution<Purchase> {

	// CT01
	public class OrderProcessing01 {
		@Logging01
		public void registerPurchase(Purchase p) {
		}
	}

	@Test
	public void CT01() throws AnnotationValidationException {
		MetadataValidator.validateMetadataOn(OrderProcessing01.class);
	}

	// CT02
	public class OrderProcessing02 {
		@Logging01
		@OptimizeExecution01
		public void registerPurchase(Purchase p) {
		}
	}

	@Test(expected = AnnotationValidationException.class)
	public void CT02() throws AnnotationValidationException {
		MetadataValidator.validateMetadataOn(OrderProcessing02.class);
	}

	// CT03
	@OptimizeExecution01
	public class OrderProcessing03 {
		@Logging01
		public void registerPurchase(Purchase p) {
		}
	}

	@Test(expected = AnnotationValidationException.class)
	public void CT03() throws AnnotationValidationException {
		MetadataValidator.validateMetadataOn(OrderProcessing03.class);
	}

	// CT04
	@Test(expected = AnnotationValidationException.class)
	public void CT04() throws AnnotationValidationException {
		MetadataValidator.validateMetadataOn(OrderProcessing04.class);
	}

	// CT05 
	public class OrderProcessing05 {
		@Logging01 @Administration01
		public void registerPurchase(Purchase p) {
		}
	}

	@Test(expected = AnnotationValidationException.class)
	public void CT05() throws AnnotationValidationException {
		MetadataValidator.validateMetadataOn(OrderProcessing05.class);
	}

	// CT06
	@Administration01
	public class OrderProcessing06 {
		@Logging01
		public void registerPurchase(Purchase p) {
		}
	}

	@Test(expected = AnnotationValidationException.class)
	public void CT06() throws AnnotationValidationException {
		MetadataValidator.validateMetadataOn(OrderProcessing06.class);
	}

	// CT07
	@Test(expected = AnnotationValidationException.class)
	public void CT07() throws AnnotationValidationException {
		MetadataValidator.validateMetadataOn(OrderProcessing07.class);
	}

	// CT08
	public class OrderProcessing08 {
		@Logging02
		public void registerPurchase(Purchase p) {
		}
	}

	@Test
	public void CT08() throws AnnotationValidationException {
		MetadataValidator.validateMetadataOn(OrderProcessing08.class);
	}

	// CT09
	public class OrderProcessing09 {
		@Logging02
		@OptimizeExecution02
		public void registerPurchase(Purchase p) {
		}
	}

	@Test(expected = AnnotationValidationException.class)
	public void CT09() throws AnnotationValidationException {
		MetadataValidator.validateMetadataOn(OrderProcessing09.class);
	}

	// CT10
	@OptimizeExecution02
	public class OrderProcessing10 {
		@Logging02
		public void registerPurchase(Purchase p) {
		}
	}

	@Test(expected = AnnotationValidationException.class)
	public void CT10() throws AnnotationValidationException {
		MetadataValidator.validateMetadataOn(OrderProcessing10.class);
	}

	// CT11
	@Test(expected = AnnotationValidationException.class)
	public void CT11() throws AnnotationValidationException {
		MetadataValidator.validateMetadataOn(OrderProcessing11.class);
	}

	// CT12
	public class OrderProcessing12 {
		@Logging02
		@Administration02
		public void registerPurchase(Purchase p) {
		}
	}

	@Test
	public void CT12() throws AnnotationValidationException {
		MetadataValidator.validateMetadataOn(OrderProcessing12.class);
	}

	// CT13
	@Administration02
	public class OrderProcessing13 {
		@Logging01
		public void registerPurchase(Purchase p) {
		}
	}

	@Test
	public void CT13() throws AnnotationValidationException {
		MetadataValidator.validateMetadataOn(OrderProcessing13.class);
	}

	// CT14
	@Test
	public void CT14() throws AnnotationValidationException {
		MetadataValidator.validateMetadataOn(OrderProcessing14.class);
	}

	// CT15
	public class OrderProcessing15 {
		@Logging03
		public void registerPurchase(Purchase p) {
		}
	}

	@Test
	public void CT15() throws AnnotationValidationException {
		MetadataValidator.validateMetadataOn(OrderProcessing15.class);
	}

	// CT16
	public class OrderProcessing16 {
		@Logging03
		@OptimizeExecution03
		public void registerPurchase(Purchase p) {
		}
	}

	@Test(expected = AnnotationValidationException.class)
	public void CT16() throws AnnotationValidationException {
		MetadataValidator.validateMetadataOn(OrderProcessing16.class);
	}

	// CT17
	@OptimizeExecution03
	public class OrderProcessing17 {
		@Logging03
		public void registerPurchase(Purchase p) {
		}
	}

	@Test
	public void CT17() throws AnnotationValidationException {
		MetadataValidator.validateMetadataOn(OrderProcessing17.class);
	}

	// CT18
	@Test
	public void CT18() throws AnnotationValidationException {
		MetadataValidator.validateMetadataOn(OrderProcessing18.class);
	}

	// CT19 
	public class OrderProcessing19 {
		@Logging03
		@Administration03
		public void registerPurchase(Purchase p) {
		}
	}

	@Test(expected = AnnotationValidationException.class)
	public void CT19() throws AnnotationValidationException {
		MetadataValidator.validateMetadataOn(OrderProcessing19.class);
	}

	// CT20 
	@Administration03
	public class OrderProcessing20 {
		@Logging03
		public void registerPurchase(Purchase p) {
		}
	}

	@Test
	public void CT20() throws AnnotationValidationException {
		MetadataValidator.validateMetadataOn(OrderProcessing20.class);
	}
	
	// CT21 
	@Test
	public void CT21() throws AnnotationValidationException {
		MetadataValidator.validateMetadataOn(OrderProcessing21.class);
	}
	
	// CT22	
	public class OrderProcessing22 {
		@Logging04
		public void registerPurchase(Purchase p) {
		}
	}

	@Test
	public void CT22() throws AnnotationValidationException {
		MetadataValidator.validateMetadataOn(OrderProcessing22.class);
	}
	
	// CT23
		public class OrderProcessing23 {
			@Logging04
			@OptimizeExecution04
			public void registerPurchase(Purchase p) {
			}
		}

		@Test(expected = AnnotationValidationException.class)
		public void CT23() throws AnnotationValidationException {
			MetadataValidator.validateMetadataOn(OrderProcessing23.class);
		}

		// CT24
		@OptimizeExecution04
		public class OrderProcessing24 {
			@Logging04
			public void registerPurchase(Purchase p) {
			}
		}

		@Test
		public void CT24() throws AnnotationValidationException {
			MetadataValidator.validateMetadataOn(OrderProcessing24.class);
		}

		// CT25
		@Test
		public void CT25() throws AnnotationValidationException {
			MetadataValidator.validateMetadataOn(OrderProcessing25.class);
		}

		// CT26 
		public class OrderProcessing26 {
			@Logging04
			@Administration04
			public void registerPurchase(Purchase p) {
			}
		}
		
		@Test
		public void CT26() throws AnnotationValidationException {
			MetadataValidator.validateMetadataOn(OrderProcessing26.class);
		}
		
		// CT27
		@Administration04
		public class OrderProcessing27 {
			@Logging04			
			public void registerPurchase(Purchase p) {
			}
		}
		
		@Test
		public void CT27() throws AnnotationValidationException {
			MetadataValidator.validateMetadataOn(OrderProcessing27.class);
		}
		
		// CT28		
		@Test
		public void CT28() throws AnnotationValidationException {
			MetadataValidator.validateMetadataOn(OrderProcessing28.class);
		}

}
