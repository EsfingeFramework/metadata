package org.esfinge.metadata.foo.validator;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.esfinge.metadata.foo.annotation.InstanceFieldOnly;

public class ValidateInstanceFieldOnly extends ValidateFather {
	
	@Override
	public String getErrorMessage(Class<?> clazz, Field field, String modifiers, Class<? extends Annotation> annotation){		
		return "The field " + field.getName() + " in the " + clazz 
				+ " is using the @" + annotation.getSimpleName() + " annotation, however it has static modifier.\n"
				+ "(it has this(these) modifier(s): " + modifiers + " )";		
	}
	
	@Override	
	public String validateField(Class<?> clazz, Field field){
		String error = "";
		
		if(field.isAnnotationPresent(InstanceFieldOnly.class)){
			String modifiers = Modifier.toString(field.getModifiers());
			
			if(modifiers.contains("static"))
				error = getErrorMessage(clazz, field, modifiers, InstanceFieldOnly.class);
			
		}
		
		return error;
	}
	
//	public boolean validateAnnotationInObject(Object someObject) throws Exception{
//		StringBuilder errorsBuilder = new StringBuilder();
//
//		Class<?> clazz = someObject.getClass();		
//		Field[] declaredFields = clazz.getDeclaredFields();
//		
//		for(Field field: declaredFields){			
//			String error = validateField(clazz, field);
//			
//			if(!error.equals(""))						
//				errorsBuilder.append(error + "\n");			
//		}
//		
//		String errors = errorsBuilder.toString();
//		if(!errors.equals(""))
//			throw new Exception(errors);
//		
//		return true;
//	}

}
