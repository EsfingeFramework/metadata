package org.esfinge.metadata.foo.validator;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public abstract class ValidateFather {
		
	public abstract String getErrorMessage(Class<?> clazz, Field field, String modifiers, Class<? extends Annotation> annotation);
	
	public abstract String validateField(Class<?> clazz, Field field);
	
	public boolean validateAnnotationInObject(Object someObject) throws Exception{
		StringBuilder errorsBuilder = new StringBuilder();

		Class<?> clazz = someObject.getClass();		
		Field[] declaredFields = clazz.getDeclaredFields();
		
		for(Field field: declaredFields){			
			String error = validateField(clazz, field);
			
			if(!error.equals(""))						
				errorsBuilder.append(error + "\n");			
		}
		
		String errors = errorsBuilder.toString();
		if(!errors.equals(""))
			throw new Exception(errors);
		
		return true;
	}

}
