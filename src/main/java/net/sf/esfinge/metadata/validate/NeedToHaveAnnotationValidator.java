package net.sf.esfinge.metadata.validate;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;

import net.sf.esfinge.metadata.AnnotationFinder;
import net.sf.esfinge.metadata.AnnotationReadingException;
import net.sf.esfinge.metadata.AnnotationValidationException;
import net.sf.esfinge.metadata.AnnotationValidator;
import net.sf.esfinge.metadata.annotation.validator.NeedsToHave;

public class NeedToHaveAnnotationValidator implements AnnotationValidator{
	
	private Class<? extends Annotation> whatItNeedsToHave;

	@Override
	public void initialize(Annotation self) {
		NeedsToHave nth = (NeedsToHave) self;
		whatItNeedsToHave = nth.value();
	}

	@Override
	public void validate(Annotation toValidate, AnnotatedElement annotated) throws AnnotationValidationException, AnnotationReadingException {
		
		if(AnnotationFinder.findAnnotation(annotated, whatItNeedsToHave).size() <= 0){
			throw new AnnotationValidationException("The annotation it needs to have is missing, whatItNeedsToHave = " + whatItNeedsToHave.toString());
		}
	}

}
