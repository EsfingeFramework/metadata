package org.esfinge.metadata.validate.method;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;

import org.esfinge.metadata.AnnotationValidationException;
import org.esfinge.metadata.AnnotationValidator;

public class ValidatorSynchronizedMethodOnly implements AnnotationValidator {
	
	private UtilValidatorModifierMethodOnly validator = null;
	
	@Override
	public void initialize(Annotation self) {								
		this.validator = new UtilValidatorModifierMethodOnly();
		this.validator.setModifiersNameObliged("synchronized");
	}

	@Override
	public void validate(Annotation toValidate, 
							AnnotatedElement annotated)
									throws AnnotationValidationException {
		
		this.validator.validate(toValidate, annotated);	
	}	
}
