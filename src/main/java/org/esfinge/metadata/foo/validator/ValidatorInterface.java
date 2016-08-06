package org.esfinge.metadata.foo.validator;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public interface ValidatorInterface {
		
	public String verifyValidAnnotationInField(Class<?> classConcrete, 
												Field field,
												Class<? extends Annotation> classOfAnnotationInField, 
												Class<? extends Annotation> classOfSubAnnotation);

	public String verifyValidAnnotationInMethod(Class<?> classConcrete, 
												Method method,
												Class<? extends Annotation> classOfAnnotationInMethod, 
												Class<? extends Annotation> classOfSubAnnotation);

}
