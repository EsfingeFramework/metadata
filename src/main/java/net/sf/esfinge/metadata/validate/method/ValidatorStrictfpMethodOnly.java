package net.sf.esfinge.metadata.validate.method;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;

import net.sf.esfinge.metadata.AnnotationValidationException;
import net.sf.esfinge.metadata.AnnotationValidator;

public class ValidatorStrictfpMethodOnly implements AnnotationValidator {
	
	private UtilValidatorModifierMethodOnly validator = null;
	
	@Override
	public void initialize(Annotation self) {						
		this.validator = new UtilValidatorModifierMethodOnly();		
		this.validator.setModifiersNameObliged("strictfp");
	}

	@Override
	public void validate(Annotation toValidate, 
							AnnotatedElement annotated)
									throws AnnotationValidationException {	
		
		this.validator.validate(toValidate, annotated);	
	}
	
}
