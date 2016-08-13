package org.esfinge.metadata.validate.method;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;

import org.esfinge.metadata.AnnotationValidationException;
import org.esfinge.metadata.AnnotationValidator;

public class ValidatorValidMethodReturn implements AnnotationValidator {
	
	private ValidatorModifierMethodOnly validator = null;
	
	@Override
	public void initialize(Annotation self) {								
		this.validator = new ValidatorModifierMethodOnly();
		this.validator.setModifiersNameObliged("transient");
	}

	@Override
	public void validate(Annotation toValidate, 
							AnnotatedElement annotated)
									throws AnnotationValidationException {
		
		this.validator.validate(toValidate, annotated);	
	}	
}
