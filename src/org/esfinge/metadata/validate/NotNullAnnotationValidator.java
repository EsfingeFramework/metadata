package org.esfinge.metadata.validate;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;

import org.esfinge.metadata.AnnotationPropertyValidator;
import org.esfinge.metadata.AnnotationValidationException;

public class NotNullAnnotationValidator implements AnnotationPropertyValidator{	
	
	@Override
	public void initialize(Annotation self) {
		
	}

	@Override
	public void validate(Annotation annotationOnElement,
			AnnotatedElement annotatedWithMainAnnotation,
			Method annotatedWithValidation, Object annotationPropertyValue)
			throws AnnotationValidationException {
		
		if(annotationPropertyValue.equals("") ||
				annotationPropertyValue == null){
			throw new AnnotationValidationException("The attribute "+ annotatedWithValidation.getName() +" of @" +annotationOnElement.annotationType().getName() + " can not be empty/null!");
		}
		
	
		
	}
}
