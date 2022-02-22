package net.sf.esfinge.metadata.validate.minValue;

import net.sf.esfinge.metadata.AnnotationReadingException;
import org.junit.Test;

import net.sf.esfinge.metadata.AnnotationValidationException;
import net.sf.esfinge.metadata.validate.MetadataValidator;

public class TestValidateMinValue {

	public class Classe{
		@PointsToUser(name="pontoA", quantity=-1)
		public void registrar(){
			
		}
	}
	
	@Test(expected = AnnotationValidationException.class)
	public void CT01() throws AnnotationValidationException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException, AnnotationReadingException {
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
