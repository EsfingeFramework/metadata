package org.esfinge.metadata.foo.validator.implementation;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.esfinge.metadata.foo.annotation.FieldVisibilityRequired;
import org.esfinge.metadata.foo.validator.ValidatorInterface;

public class ValidatorFieldVisibilityRequired implements ValidatorInterface {
	
	private Class<FieldVisibilityRequired> annotation = FieldVisibilityRequired.class;
	
	public String getErrorMessage(Class<?> clazz, Field field, String modifiers, String visibility){		
		return "The field " + field.getName() + " in the " + clazz.getSimpleName() + " is using the @" + annotation.getSimpleName() 
				+ " annotation, with this(these) modifier(s): " + modifiers 
				+ ", however it needs to use this: " + visibility + ".\n";
	}
	
	@Override	
	public String validateField(Class<?> clazz, Field field){
		String error = "";
		
		if(field.isAnnotationPresent(annotation)){
			String modifiers = Modifier.toString(field.getModifiers());

			FieldVisibilityRequired fvr = field.getAnnotation(annotation);			
			String visibility = fvr.itNeedsToHaveThisVisibility();
			
			if(visibility.equals("default") || visibility.equals("")){					
				if( modifiers.contains("public") || modifiers.contains("private") || modifiers.contains("protected") )						
					error = getErrorMessage(clazz, field, modifiers, "default");			
			} else {				
				if(!modifiers.contains(visibility))
					error = getErrorMessage(clazz, field, modifiers, visibility);				
			}
			
		}
		
		return error;
	}
}
