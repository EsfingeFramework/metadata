package org.esfinge.metadata.validate;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;

import org.esfinge.metadata.AnnotationValidationException;
import org.esfinge.metadata.AnnotationValidator;
import org.esfinge.metadata.annotation.validator.ValidFieldType;

public class ValidFieldTypeValidator implements AnnotationValidator {

	private Class<?>[] validType;
	
	@Override
	public void initialize(Annotation self) {
		ValidFieldType validFieldType = (ValidFieldType) self;
		validType = validFieldType.value();
	}

	@Override
	public void validate(Annotation toValidate, AnnotatedElement annotated) throws AnnotationValidationException {
		boolean x = false;
		Field field = (Field)annotated;
		for(Class<?> clazz : validType)
		{		
			if(field.getType().equals(clazz))
			{
				x = true;
			}
		}
		if(!x)
		{
			throw new AnnotationValidationException("The field "+annotated.toString()+" with annotation @" 
						+ toValidate.annotationType().getName()+ " should be of one of the types " );
		}
	}

}
