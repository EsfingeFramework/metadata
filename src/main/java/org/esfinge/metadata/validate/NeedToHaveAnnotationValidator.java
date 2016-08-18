package org.esfinge.metadata.validate;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;

import org.esfinge.metadata.AnnotationFinder;
import org.esfinge.metadata.AnnotationValidationException;
import org.esfinge.metadata.AnnotationValidator;
import org.esfinge.metadata.annotation.validator.NeedsToHave;

public class NeedToHaveAnnotationValidator implements AnnotationValidator{
	
	private Class<? extends Annotation> whatItNeedsToHave;

	@Override
	public void initialize(Annotation self) {
		NeedsToHave nth = (NeedsToHave) self;
		whatItNeedsToHave = nth.value();
	}

	@Override
	public void validate(Annotation toValidate, AnnotatedElement annotated) throws AnnotationValidationException {
		if(AnnotationFinder.findAnnotation(annotated, whatItNeedsToHave).size() <= 0){
			throw new AnnotationValidationException("The annotation it needs to have is missing, whatItNeedsToHave = " + whatItNeedsToHave.toString());
		}
	}

}
