package net.sf.esfinge.metadata.validate;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;

import net.sf.esfinge.metadata.AnnotationPropertyValidator;
import net.sf.esfinge.metadata.AnnotationValidationException;
import net.sf.esfinge.metadata.annotation.validator.MinValue;

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
		System.out.println("----------------");
		System.out.println(annotatedWithValidation.toString());
		Integer value = (Integer) annotationPropertyValue;
		if(minValue > value){
			throw new AnnotationValidationException("The attribute "+ annotatedWithValidation.getName() +" of @" +annotationOnElement.annotationType().getName() + " has a value("+value+"), which is less than the @MinValue("+minValue+")");
		}
		
	
		
	}

	
}
	