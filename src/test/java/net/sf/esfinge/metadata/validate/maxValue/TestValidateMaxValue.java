package net.sf.esfinge.metadata.validate.maxValue;

import org.junit.Test;

import net.sf.esfinge.metadata.AnnotationValidationException;
import net.sf.esfinge.metadata.validate.MetadataValidator;
import net.sf.esfinge.metadata.validate.minValue.PointsToUser;

public class TestValidateMaxValue {

	public class Classe{
		@PointsToUser(name="pontoA", quantity=11)
		public void registrar(){
			
		}
	}
	
	@Test (expected = AnnotationValidationException.class)
	public void CT01() throws Exception {			
		MetadataValidator.validateMetadataOn(Classe.class);		
		
	}
	
	/*
	public class OrderProcessing01 {
		@MaxValue(value=1000)
		public int price;
		
		@MaxValue(value=99)
		public int saleValue;
		
		public void registerPurchase() {
			//method implementation
		}
	}
	
	@Test(expected = AnnotationValidationException.class)
	public void CT01() throws AnnotationValidationException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {			
		OrderProcessing01 instancia = new OrderProcessing01();
		instancia.price = 1001;
		instancia.saleValue = 99;
		MetadataValidator.validateMetadataOn(instancia.getClass(), instancia);			
	}
	
	@Test
	public void CT02() throws AnnotationValidationException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {			
		OrderProcessing01 instancia = new OrderProcessing01();
		instancia.price = 999;
		instancia.saleValue = 99;
		MetadataValidator.validateMetadataOn(instancia.getClass(), instancia);			
	}	

	@Test(expected = AnnotationValidationException.class)
	public void CT03() throws AnnotationValidationException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {			
		OrderProcessing01 instancia = new OrderProcessing01();
		instancia.saleValue = 100;
		instancia.price = 1000;
		MetadataValidator.validateMetadataOn(instancia.getClass(), instancia);			
	}
	
	@Test
	public void CT04() throws AnnotationValidationException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {			
		OrderProcessing01 instancia = new OrderProcessing01();
		instancia.saleValue = 99;
		instancia.price = 1000;
		MetadataValidator.validateMetadataOn(instancia.getClass(), instancia);			
	}	

	
	*/
}
