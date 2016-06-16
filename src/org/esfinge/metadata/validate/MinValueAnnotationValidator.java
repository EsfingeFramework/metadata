package org.esfinge.metadata.validate;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;

import org.esfinge.metadata.AnnotationPropertyValidator;
import org.esfinge.metadata.AnnotationValidationException;
import org.esfinge.metadata.annotation.MinValue;

public class MinValueAnnotationValidator implements AnnotationPropertyValidator{
	private int minValue;
	private MinValue mv;

	@Override
	public void initialize(Annotation self) {
		mv = (MinValue) self;
		minValue = mv.value();
	}
	
	@Override
	public void validate(Annotation annotationOnElement,
			AnnotatedElement annotatedWithMainAnnotation,
			Method annotatedWithValidation, Object annotationPropertyValue)
			throws AnnotationValidationException {
		
		Integer value = (Integer) annotationPropertyValue;
		if(minValue > value){
			throw new AnnotationValidationException("The attribute "+ annotatedWithValidation.getName() +" of @" +annotationOnElement.annotationType().getName() + " has a value("+value+"), which is less than the @MinValue("+minValue+")");
		}
		
	
		
	}

	
}
	