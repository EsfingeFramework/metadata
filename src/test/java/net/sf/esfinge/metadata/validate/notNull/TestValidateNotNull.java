package net.sf.esfinge.metadata.validate.notNull;

import org.junit.Test;

import net.sf.esfinge.metadata.AnnotationValidationException;
import net.sf.esfinge.metadata.validate.MetadataValidator;

public class TestValidateNotNull {
	
	
	public class Classe{
		@PointsToUser(name="", quantity=10)
		public void registrar(){
			
		}
	}
	
	@Test(expected = AnnotationValidationException.class)
	public void CT01() throws Exception {			
		MetadataValidator.validateMetadataOn(Classe.class);

	}
	
	
//	@Test(expected = AnnotationValidationException.class)
	//	public void CT02() throws Exception {			
	//
	//boolean ann = AnnotationFinder.existAnnotation(PointsToUser.class, NotNull.class);
	//
	//	
	//}
	
	/*
	public class OrderProcessing01 {
		@NotNull
		public String price;		
		@NotNull
		public String saleValue;
		
		public void registerPurchase() {
			//method implementation
		}
	}
	
	@Test(expected = AnnotationValidationException.class)
	public void CT01() throws AnnotationValidationException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {			
		OrderProcessing01 instancia = new OrderProcessing01();
		instancia.price = "";
		instancia.saleValue = "99";
		MetadataValidator.validateMetadataOn(instancia.getClass(), instancia);			
	}
	
	@Test
	public void CT02() throws AnnotationValidationException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {			
		OrderProcessing01 instancia = new OrderProcessing01();
		instancia.price = "999";
		instancia.saleValue = "99";
		MetadataValidator.validateMetadataOn(instancia.getClass(), instancia);			
	}
	
	@Test(expected = AnnotationValidationException.class)
	public void CT03() throws AnnotationValidationException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {			
		OrderProcessing01 instancia = new OrderProcessing01();
		instancia.price = "99";
		instancia.saleValue = "";
		MetadataValidator.validateMetadataOn(instancia.getClass(), instancia);			
	}
	
	@Test(expected = AnnotationValidationException.class)
	public void CT04() throws AnnotationValidationException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {			
		OrderProcessing01 instancia = new OrderProcessing01();
		instancia.price = "";
		instancia.saleValue = "";
		MetadataValidator.validateMetadataOn(instancia.getClass(), instancia);			
	}
	*/
}
