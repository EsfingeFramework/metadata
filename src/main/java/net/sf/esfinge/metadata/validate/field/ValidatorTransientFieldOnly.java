package net.sf.esfinge.metadata.validate.field;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;

import net.sf.esfinge.metadata.AnnotationValidationException;
import net.sf.esfinge.metadata.AnnotationValidator;

public class ValidatorTransientFieldOnly implements AnnotationValidator {
	
	private UtilValidatorModifierFieldOnly validator = null;
	
	@Override
	public void initialize(Annotation self) {								
		this.validator = new UtilValidatorModifierFieldOnly();
		this.validator.setModifiersNameObliged("transient");
	}

	@Override
	public void validate(Annotation toValidate, 
							AnnotatedElement annotated)
									throws AnnotationValidationException {
		
		this.validator.validate(toValidate, annotated);	
	}	
}
