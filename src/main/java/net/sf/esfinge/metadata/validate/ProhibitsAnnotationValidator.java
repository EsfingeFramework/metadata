package net.sf.esfinge.metadata.validate;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;

import net.sf.esfinge.metadata.AnnotationFinder;
import net.sf.esfinge.metadata.AnnotationValidationException;
import net.sf.esfinge.metadata.AnnotationValidator;
import net.sf.esfinge.metadata.annotation.validator.Prohibits;

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
