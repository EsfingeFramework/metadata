package org.esfinge.metadata.foo.validator.implementation;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.esfinge.metadata.foo.annotation.fieldonly.InstanceFieldOnly;
import org.esfinge.metadata.foo.validator.old.ValidatorInterface;

public class ValidatorInstanceFieldOnly implements ValidatorInterface {
	
	private Class<InstanceFieldOnly> annotation = InstanceFieldOnly.class;
	
	public String getErrorMessage(Class<?> clazz, Field field, String modifiers){		
		return "The field " + field.getName() + " in the " + clazz.getSimpleName() 
				+ " is using the @" + annotation.getSimpleName() + " annotation, however it has static modifier.\n"
				+ "(it has this(these) modifier(s): " + modifiers + " )";		
	}
	
	@Override	
	public String validateField(Class<?> clazz, Field field){
		String error = "";
		
		if(field.isAnnotationPresent(annotation)){
			String modifiers = Modifier.toString(field.getModifiers());
			
			if(modifiers.contains("static"))
				error = getErrorMessage(clazz, field, modifiers);
			
		}
		
		return error;
	}
}
