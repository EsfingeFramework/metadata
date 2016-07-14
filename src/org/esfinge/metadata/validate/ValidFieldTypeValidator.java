package org.esfinge.metadata.validate;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;

import org.esfinge.metadata.AnnotationValidationException;
import org.esfinge.metadata.AnnotationValidator;
import org.esfinge.metadata.annotation.validator.ToValidate;
import org.esfinge.metadata.annotation.validator.ValidFieldType;

public class ValidFieldTypeValidator implements AnnotationValidator {

	@Override
	public void initialize(Annotation self) {
		// TODO Auto-generated method stub

	}

	@Override
	public void validate(Annotation toValidate, AnnotatedElement annotated) throws AnnotationValidationException {
		// TODO Auto-generated method stub
		boolean x = false;
		Field elementAnnot =(Field) annotated;
		ValidFieldType validFieldType = toValidate.annotationType().getDeclaredAnnotation(ValidFieldType.class);
		for(Class<?> clazz : validFieldType.value())
		{
			if(elementAnnot.getType().getName().equals(clazz.getTypeName()))
			{
				x = true;
				break;
			}
		}
		if(x==false)
		{
			throw new AnnotationValidationException("Class not same type of element");
		}
	}

}
