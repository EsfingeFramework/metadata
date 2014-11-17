package org.esfinge.metadata.validate;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;

import org.esfinge.metadata.AnnotationFinder;

public class NeedToHaveAnnotationValidator implements AnnotationValidator{
	
	private Class<? extends Annotation> whatItNeedsToHave;

	@Override
	public void initialize(Annotation self) {
		NeedsToHave nth = (NeedsToHave) self;
		whatItNeedsToHave = nth.value();
	}

	@Override
	public void validate(Annotation toValidate, AnnotatedElement annotated) throws AnnotationValidationException {
		if(AnnotationFinder.findAnnotation(annotated, whatItNeedsToHave) == null){
			throw new AnnotationValidationException();
		}
	}

}
