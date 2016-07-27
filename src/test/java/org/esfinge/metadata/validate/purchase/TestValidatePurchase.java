package org.esfinge.metadata.validate.purchase;

import org.esfinge.metadata.AnnotationValidationException;
import org.esfinge.metadata.validate.MetadataValidator;
import org.junit.Test;

public class TestValidatePurchase {
	
	public class CT01{
		@Purchase(id="123", total=10001)
		public void registrar(){
			
		}
	}
	
	@Test(expected = AnnotationValidationException.class)
	public void CT01() throws AnnotationValidationException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {			
		MetadataValidator.validateMetadataOn(CT01.class);			
	}
	
	public class CT02{
		@Purchase(id="123", total=9999)
		public void registrar(){
			
		}
	}
	
	@Test
	public void CT02() throws AnnotationValidationException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {			
		MetadataValidator.validateMetadataOn(CT02.class);			
	}
	
	public class CT03{
		@Purchase(id="", total=9999)
		public void registrar(){
			
		}
	}
	
	//@Test(expected = AnnotationValidationException.class)
	public void CT03() throws AnnotationValidationException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {			
		MetadataValidator.validateMetadataOn(CT03.class);			
	}

}
