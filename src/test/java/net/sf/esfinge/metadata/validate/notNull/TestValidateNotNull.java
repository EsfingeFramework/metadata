package net.sf.esfinge.metadata.validate.notNull;

import java.lang.annotation.Annotation;
import java.util.List;

import org.junit.Test;

import net.sf.esfinge.metadata.AnnotationFinder;
import net.sf.esfinge.metadata.AnnotationValidationException;
import net.sf.esfinge.metadata.annotation.validator.NotNull;
import net.sf.esfinge.metadata.annotation.validator.field.FinalFieldOnly;
import net.sf.esfinge.metadata.locate.AnnotationLocator;
import net.sf.esfinge.metadata.locate.LevelLocator;
import net.sf.esfinge.metadata.locate.MetadataLocator;
import net.sf.esfinge.metadata.locate.RegularLocator;
import net.sf.esfinge.metadata.locate.levelLocator.TestLevelLocator.CT01;
import net.sf.esfinge.metadata.validate.MetadataValidator;
import net.sf.esfinge.metadata.validate.MetadataValidatorB;
import net.sf.esfinge.metadata.validate.notNull.PointsToUser;

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
	
	
	@Test(expected = AnnotationValidationException.class)
	public void CT02() throws Exception {			
		//MetadataValidatorB.validateMetadataOn(Classe.class);
		//AnnotationLocator ann = new AnnotationLocator();
		//Annotation x = ann.findMetadata(Classe.class, NotNull.class);
		
		//LevelLocator annLevel = new LevelLocator();
		//Annotation xLevel = annLevel.findMetadata(Classe.class, NotNull.class);

		boolean ann = AnnotationFinder.existAnnotation(PointsToUser.class, NotNull.class);
		
		System.out.println(ann);
		
		//System.out.println(x);
		//System.out.println(xLevel);
		
	}
	
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
