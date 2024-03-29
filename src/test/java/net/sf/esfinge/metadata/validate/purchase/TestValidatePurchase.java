package net.sf.esfinge.metadata.validate.purchase;

import net.sf.esfinge.metadata.AnnotationReadingException;
import org.junit.Test;

import net.sf.esfinge.metadata.AnnotationValidationException;
import net.sf.esfinge.metadata.validate.MetadataValidator;

public class TestValidatePurchase {
	
	public class CT01{
		@Purchase(id="123", total=10001)
		public void registrar(){
			
		}
	}
	
	@Test(expected = AnnotationValidationException.class)
	public void CT01() throws AnnotationValidationException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException, AnnotationReadingException {
		MetadataValidator.validateMetadataOn(CT01.class);			
	}
	
	public class CT02{
		@Purchase(id="123", total=9999)
		public void registrar(){
			
		}
	}
	
	@Test
	public void CT02() throws AnnotationValidationException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException, AnnotationReadingException {
		MetadataValidator.validateMetadataOn(CT02.class);			
	}
	
	public class CT03{
		@Purchase(id="", total=9999)
		public void registrar(){
			
		}
	}
	
	@Test(expected = AnnotationValidationException.class)
	public void CT03() throws AnnotationValidationException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException, AnnotationReadingException {
		MetadataValidator.validateMetadataOn(CT03.class);			
	}

	public interface CT04{
		@Purchase(id="OK", total=9999)
		public void registrar();
	}
	
	@Test
	public void CT04() throws AnnotationValidationException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException, AnnotationReadingException {
		MetadataValidator.validateMetadataOn(CT04.class);			
	}

}
