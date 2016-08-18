package org.esfinge.metadata;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;

public interface AnnotationPropertyValidator {

	public void initialize(Annotation self);

	public void validate(Annotation annotationOnElement, 
			AnnotatedElement annotatedWithMainAnnotation, 
			Method annotatedWithValidation, 
			Object annotationPropertyValue)
			throws AnnotationValidationException;
	
}
