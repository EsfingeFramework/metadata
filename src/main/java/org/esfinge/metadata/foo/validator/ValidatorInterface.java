package org.esfinge.metadata.foo.validator;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public interface ValidatorInterface {
		
	public String verifyValidAnnotation(Class<?> classConcrete, 
										Field field,
										Class<? extends Annotation> classOfAnnotationInField, 
										Class<? extends Annotation> classOfSubAnnotation);

}
