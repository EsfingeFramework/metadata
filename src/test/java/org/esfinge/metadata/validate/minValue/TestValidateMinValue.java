package org.esfinge.metadata.validate.minValue;

import org.esfinge.metadata.AnnotationValidationException;
import org.esfinge.metadata.validate.MetadataValidator;
import org.junit.Test;

public class TestValidateMinValue {

	public class Classe{
		@PointsToUser(name="pontoA", quantity=-1)
		public void registrar(){
			
		}
	}
	
	@Test(expected = AnnotationValidationException.class)
	public void CT01() throws AnnotationValidationException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {			
		MetadataValidator.validateMetadataOn(Classe.class);			
	}
	
	/*
	@Test(expected = AnnotationValidationException.class)
	public void CT02() throws AnnotationValidationException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {			
		OrderProcessing01 instancia = new OrderProcessing01();
		instancia.price = 999;
		instancia.saleValue = 99;
		MetadataValidator.validateMetadataOn(instancia.getClass(), instancia);			
	}	

	@Test
	public void CT03() throws AnnotationValidationException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {			
		OrderProcessing01 instancia = new OrderProcessing01();
		instancia.saleValue = 100;
		instancia.price = 1001;
		MetadataValidator.validateMetadataOn(instancia.getClass(), instancia);			
	}
	
	@Test(expected = AnnotationValidationException.class)
	public void CT04() throws AnnotationValidationException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {			
		OrderProcessing01 instancia = new OrderProcessing01();
		instancia.saleValue = 99;	
		MetadataValidator.validateMetadataOn(instancia.getClass(), instancia);			
	}	

	*/
	
}
