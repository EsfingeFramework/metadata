package org.esfinge.metadata.foo.validator.implementation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.esfinge.metadata.foo.annotation.FinalFieldOnly;
import org.esfinge.metadata.foo.validator.ValidatorInterface;

public class ValidatorFinalFieldOnly implements ValidatorInterface {
	
	public String getErrorMessage(Class<?> clazz, Field field, String modifiers, 
									Class<? extends Annotation> annotation, 
									String modifiers_name){		
		
		return "The field " + field.getName() + " in the " + clazz 
				+ " is using the @" + annotation.getSimpleName() + " annotation, however it has no " + modifiers_name + " modifier.\n"
				+ "(it has this(these) modifier(s): " + modifiers + " )";		
	}
	
	@Override	
	public String validateField(Class<?> clazz, Field field){
		String error = "";
		
		if(field.isAnnotationPresent(FinalFieldOnly.class)){
			String modifiers = Modifier.toString(field.getModifiers());
			
			if(!modifiers.contains("final")){					
				if(modifiers.equals("")) modifiers = "default";
							
				error = getErrorMessage(clazz, field, modifiers, FinalFieldOnly.class, "final");			
			}			
		}
		
		return error;
	}
	
}
