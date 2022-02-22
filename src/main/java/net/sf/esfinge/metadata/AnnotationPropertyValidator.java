package net.sf.esfinge.metadata;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;

import net.sf.esfinge.metadata.annotation.container.ExecuteProcessor;

public interface AnnotationPropertyValidator {

	@ExecuteProcessor
	public void initialize(Annotation self);
	

	public void validate(Annotation annotationOnElement, 
			AnnotatedElement annotatedWithMainAnnotation, 
			Method annotatedWithValidation, 
			Object annotationPropertyValue)
            throws AnnotationValidationException, AnnotationReadingException;
	
}
