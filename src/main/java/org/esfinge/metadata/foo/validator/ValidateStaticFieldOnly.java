package org.esfinge.metadata.foo.validator;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.esfinge.metadata.foo.annotation.StaticFieldOnly;

public class ValidateStaticFieldOnly {
	
	public String getErrorMessage(Class<?> clazz, Field field, String modifiers, Class<? extends Annotation> annotation){		
		return "The field " + field.getName() + " in the " + clazz 
				+ " is using the @" + annotation.getSimpleName() + " annotation, however it has no static modifier.\n"
				+ "(it has this(these) modifier(s): " + modifiers + " )";		
	}
	
	public String validateField(Class<?> clazz, Field field){
		String error = "";
		
		if(field.isAnnotationPresent(StaticFieldOnly.class)){
			String modifiers = Modifier.toString(field.getModifiers());
			
			if(!modifiers.contains("static")){					
				if(modifiers.equals("")) modifiers = "default";
							
				error = getErrorMessage(clazz, field, modifiers, StaticFieldOnly.class);			
			}			
		}
		
		return error;
	}
	
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
