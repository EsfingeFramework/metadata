package org.esfinge.metadata.validate.field;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;

import org.esfinge.metadata.AnnotationValidationException;
import org.esfinge.metadata.AnnotationValidator;

public class ValidatorVolatileFieldOnly implements AnnotationValidator {
	
	private ValidatorModifierFieldOnly validator = null;
	
	@Override
	public void initialize(Annotation self) {						
		this.validator = new ValidatorModifierFieldOnly();		
		this.validator.setModifiersNameObliged("volatile");
	}

	@Override
	public void validate(Annotation toValidate, 
							AnnotatedElement annotated)
									throws AnnotationValidationException {	
		
		this.validator.validate(toValidate, annotated);	
	}	
}
