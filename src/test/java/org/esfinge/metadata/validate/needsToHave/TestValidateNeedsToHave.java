package org.esfinge.metadata.validate.needsToHave;

import org.esfinge.metadata.AnnotationValidationException;
import org.esfinge.metadata.validate.MetadataValidator;
import org.esfinge.metadata.validate.needsToHave.CT04.OrderProcessing04;
import org.esfinge.metadata.validate.needsToHave.CT07.OrderProcessing07;
import org.esfinge.metadata.validate.needsToHave.CT11.OrderProcessing11;
import org.esfinge.metadata.validate.needsToHave.CT14.OrderProcessing14;
import org.esfinge.metadata.validate.needsToHave.CT18.OrderProcessing18;
import org.esfinge.metadata.validate.needsToHave.CT21.OrderProcessing21;
import org.esfinge.metadata.validate.needsToHave.CT25.OrderProcessing25;
import org.esfinge.metadata.validate.needsToHave.CT28.OrderProcessing28;
import org.junit.Test;

public class TestValidateNeedsToHave<Purchase> {

	// CT01
	public class OrderProcessing01 {
		@Logging01
		public void registerPurchase(Purchase p) {
		}
	}

	@Test(expected = AnnotationValidationException.class)
	public void CT01() throws AnnotationValidationException {
		MetadataValidator.validateMetadataOn(OrderProcessing01.class);
	}

	// CT02
	public class OrderProcessing02 {
		@Logging01
		@Transaction01
		public void registerPurchase(Purchase p) {
		}
	}

	@Test
	public void CT02() throws AnnotationValidationException {
		MetadataValidator.validateMetadataOn(OrderProcessing02.class);
	}

	// CT03
	@Transaction01
	public class OrderProcessing03 {
		@Logging01
		public void registerPurchase(Purchase p) {
		}
	}

	@Test
	public void CT03() throws AnnotationValidationException {
		MetadataValidator.validateMetadataOn(OrderProcessing03.class);
	}

	// CT04
	@Test
	public void CT04() throws AnnotationValidationException {
		MetadataValidator.validateMetadataOn(OrderProcessing04.class);
	}

	// CT05 
	public class OrderProcessing05 {
		@Logging01 @Administration01
		public void registerPurchase(Purchase p) {
		}
	}

	@Test
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

	@Test
	public void CT06() throws AnnotationValidationException {
		MetadataValidator.validateMetadataOn(OrderProcessing06.class);
	}

	// CT07 - Problemas com annotationLocator
	@Test
	public void CT07() throws AnnotationValidationException {
		MetadataValidator.validateMetadataOn(OrderProcessing07.class);
	}

	// CT08
	public class OrderProcessing08 {
		@Logging02
		public void registerPurchase(Purchase p) {
		}
	}

	@Test(expected = AnnotationValidationException.class)
	public void CT08() throws AnnotationValidationException {
		MetadataValidator.validateMetadataOn(OrderProcessing08.class);
	}

	// CT09
	public class OrderProcessing09 {
		@Logging02
		@Transaction02
		public void registerPurchase(Purchase p) {
		}
	}

	@Test
	public void CT09() throws AnnotationValidationException {
		MetadataValidator.validateMetadataOn(OrderProcessing09.class);
	}

	// CT10
	@Transaction02
	public class OrderProcessing10 {
		@Logging02
		public void registerPurchase(Purchase p) {
		}
	}

	@Test
	public void CT10() throws AnnotationValidationException {
		MetadataValidator.validateMetadataOn(OrderProcessing10.class);
	}

	// CT11
	@Test
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

	@Test(expected = AnnotationValidationException.class)
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

	@Test(expected = AnnotationValidationException.class)
	public void CT13() throws AnnotationValidationException {
		MetadataValidator.validateMetadataOn(OrderProcessing13.class);
	}

	// CT14
	@Test(expected = AnnotationValidationException.class)
	public void CT14() throws AnnotationValidationException {
		MetadataValidator.validateMetadataOn(OrderProcessing14.class);
	}

	// CT15
	public class OrderProcessing15 {
		@Logging03
		public void registerPurchase(Purchase p) {
		}
	}

	@Test(expected = AnnotationValidationException.class)
	public void CT15() throws AnnotationValidationException {
		MetadataValidator.validateMetadataOn(OrderProcessing15.class);
	}

	// CT16
	public class OrderProcessing16 {
		@Logging03
		@Transaction03
		public void registerPurchase(Purchase p) {
		}
	}

	@Test
	public void CT16() throws AnnotationValidationException {
		MetadataValidator.validateMetadataOn(OrderProcessing16.class);
	}

	// CT17
	@Transaction03
	public class OrderProcessing17 {
		@Logging03
		public void registerPurchase(Purchase p) {
		}
	}

	@Test(expected = AnnotationValidationException.class)
	public void CT17() throws AnnotationValidationException {
		MetadataValidator.validateMetadataOn(OrderProcessing17.class);
	}

	// CT18
	@Test(expected = AnnotationValidationException.class)
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

	@Test
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

	@Test(expected = AnnotationValidationException.class)
	public void CT20() throws AnnotationValidationException {
		MetadataValidator.validateMetadataOn(OrderProcessing20.class);
	}
	
	// CT21 
	@Test(expected = AnnotationValidationException.class)
	public void CT21() throws AnnotationValidationException {
		MetadataValidator.validateMetadataOn(OrderProcessing21.class);
	}
	
	// CT22	
	public class OrderProcessing22 {
		@Logging04
		public void registerPurchase(Purchase p) {
		}
	}

	@Test(expected = AnnotationValidationException.class)
	public void CT22() throws AnnotationValidationException {
		MetadataValidator.validateMetadataOn(OrderProcessing22.class);
	}
	
	// CT23
		public class OrderProcessing23 {
			@Logging04
			@Transaction04
			public void registerPurchase(Purchase p) {
			}
		}

		@Test
		public void CT23() throws AnnotationValidationException {
			MetadataValidator.validateMetadataOn(OrderProcessing23.class);
		}

		// CT24
		@Transaction04
		public class OrderProcessing24 {
			@Logging04
			public void registerPurchase(Purchase p) {
			}
		}

		@Test(expected = AnnotationValidationException.class)
		public void CT24() throws AnnotationValidationException {
			MetadataValidator.validateMetadataOn(OrderProcessing24.class);
		}

		// CT25
		@Test(expected = AnnotationValidationException.class)
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
		
		@Test(expected = AnnotationValidationException.class)
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
		
		@Test(expected = AnnotationValidationException.class)
		public void CT27() throws AnnotationValidationException {
			MetadataValidator.validateMetadataOn(OrderProcessing27.class);
		}
		
		// CT28		
		@Test(expected = AnnotationValidationException.class)
		public void CT28() throws AnnotationValidationException {
			MetadataValidator.validateMetadataOn(OrderProcessing28.class);
		}

}
