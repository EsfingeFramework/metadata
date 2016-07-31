package org.esfinge.metadata.foo.validator;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public interface ValidatorInterface {
	
	public String getErrorMessage(Class<?> clazz, 
									Field field, 
									String modifiers, 
									Class<? extends Annotation> annotation);	
	
	public String validateField(Class<?> clazz, Field field);

}
