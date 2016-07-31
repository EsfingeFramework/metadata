package org.esfinge.metadata.foo.validator.implementation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.esfinge.metadata.foo.annotation.InstanceFieldOnly;
import org.esfinge.metadata.foo.validator.ValidatorInterface;

public class ValidatorInstanceFieldOnly implements ValidatorInterface {
	
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
}
