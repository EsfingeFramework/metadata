package org.esfinge.metadata.validate.transaction;

import org.esfinge.metadata.AnnotationValidationException;
import org.esfinge.metadata.validate.MetadataValidator;
import org.junit.Test;

public class TestValidateTransaction {
	
	public class CT01{
		@Transaction(id="")
		public void registrar(){
			
		}
	}
	
	@Test(expected = AnnotationValidationException.class)
	public void CT01() throws AnnotationValidationException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {			
		MetadataValidator.validateMetadataOn(CT01.class);			
	}
	
	public class CT02{
		@Transaction(id="123")
		public void registrar(){
			
		}
	}
	
	@Test
	public void CT02() throws AnnotationValidationException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {			
		MetadataValidator.validateMetadataOn(CT02.class);			
	}
}
