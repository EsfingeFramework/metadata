package org.esfinge.metadata.validate.unique;

import org.esfinge.metadata.AnnotationValidationException;
import org.esfinge.metadata.validate.MetadataValidator;
import org.junit.Test;

public class TestValidateUnique {
	
	public class Classe{
		@PointsToUser(name="ponto", quantity=10)
		public void registrar(){
			
		}
		
	}
	
	@Test(expected = AnnotationValidationException.class)
	public void CT01() throws AnnotationValidationException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {			
		MetadataValidator.validateMetadataOn(Classe.class);			
	}
	
	
	/*
	public class OrderProcessing01 {
		@Unique
		public int id;
		@Unique
		public String cpf;
		public int price;
		
		public void registerPurchase() {
			//method implementation
		}
	}
	
	@Test(expected = AnnotationValidationException.class)
	public void CT01() throws AnnotationValidationException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {			
		OrderProcessing01 instancia = new OrderProcessing01();
		instancia.id = 1;
		instancia.cpf = "1234";
		
		MetadataValidator.validateMetadataOn(instancia.getClass(), instancia);			
	}
	
	public class OrderProcessing02 {
		@Unique
		public int id;
		public String cpf;
		public int price;
		
		public void registerPurchase() {
			//method implementation
		}
	}
	
	@Test
	public void CT02() throws AnnotationValidationException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {			
		OrderProcessing02 instancia = new OrderProcessing02();
		instancia.id = 1;
		instancia.cpf = "1234";
		
		MetadataValidator.validateMetadataOn(instancia.getClass(), instancia);			
	}
	
	public class OrderProcessing03 {
		int id;
		@Unique
		public String cpf;
		public int price;
		
		public void registerPurchase() {
			//method implementation
		}
	}
	
	@Test
	public void CT03() throws AnnotationValidationException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {			
		OrderProcessing03 instancia = new OrderProcessing03();
		instancia.id = 1;
		instancia.cpf = "1234";
		
		MetadataValidator.validateMetadataOn(instancia.getClass(), instancia);			
	}
	*/
}
