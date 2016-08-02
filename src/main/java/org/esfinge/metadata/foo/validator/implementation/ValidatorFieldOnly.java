package org.esfinge.metadata.foo.validator.implementation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.esfinge.metadata.foo.validator.old.ValidatorInterface;

public class ValidatorFieldOnly implements ValidatorInterface {
	
	private Class<? extends Annotation> annotation;
	private String modifiers_name;
	
	public ValidatorFieldOnly(Class<? extends Annotation> annotation, String modifiers_name) {
		this.annotation = annotation;
		this.modifiers_name = modifiers_name;
	}

	public String getErrorMessage(Class<?> clazz, Field field, String modifiers){			
		return "The field " + field.getName() + " in the " + clazz.getSimpleName() 
				+ " is using the @" + annotation.getSimpleName() + " annotation, however it has no " + modifiers_name + " modifier.\n"
				+ "(it has this(these) modifier(s): " + modifiers + " )";		
	}
	
	@Override	
	public String validateField(Class<?> clazz, Field field){
		String error = "";
		
		if(field.isAnnotationPresent(annotation)){
			String modifiers = Modifier.toString(field.getModifiers());
			
			if(!modifiers.contains(modifiers_name)){					
				if(modifiers.equals("")) modifiers = "default";
							
				error = getErrorMessage(clazz, field, modifiers);			
			}			
		}
		
		return error;
	}
	
}
