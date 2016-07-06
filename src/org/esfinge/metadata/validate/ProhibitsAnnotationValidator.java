package org.esfinge.metadata.validate;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;

import org.esfinge.metadata.AnnotationFinder;
import org.esfinge.metadata.AnnotationValidationException;
import org.esfinge.metadata.AnnotationValidator;
import org.esfinge.metadata.annotation.validator.Prohibits;

public class ProhibitsAnnotationValidator implements AnnotationValidator{
	
	protected Class<? extends Annotation> whatItNeedsToProhibits;

	@Override
	public void initialize(Annotation self) {
		Prohibits ntp = (Prohibits) self;
		whatItNeedsToProhibits = ntp.value();						
	}

	@Override
	public void validate(Annotation toValidate, AnnotatedElement annotated) throws AnnotationValidationException {		
		if(AnnotationFinder.findAnnotation(annotated, whatItNeedsToProhibits).size() > 0){
			throw new AnnotationValidationException("The annotation it needs to prohibits was found = " + whatItNeedsToProhibits.toString());
		}
	}
	
	
}
