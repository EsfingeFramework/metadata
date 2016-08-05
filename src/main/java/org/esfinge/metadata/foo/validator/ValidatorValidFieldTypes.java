package org.esfinge.metadata.foo.validator;

import java.lang.reflect.Field;

import org.esfinge.metadata.foo.annotation.visibility.ValidFieldTypes;
import org.esfinge.metadata.foo.validator.old.ValidatorInterfaceOld;

public class ValidatorValidFieldTypes implements ValidatorInterfaceOld {
	
	private Class<ValidFieldTypes> annotation = ValidFieldTypes.class;
	
	public String getErrorMessage(Class<?> clazz, Field field, Class<?> type, Class[] listValidTypes){
		
		StringBuilder concatedListValidTypes = new StringBuilder();
		concatedListValidTypes.append("[");
		for(Class<?> oneValidType: listValidTypes){
			concatedListValidTypes.append(oneValidType.getSimpleName());
			concatedListValidTypes.append(", ");
		}
		concatedListValidTypes.append("]");
		
		return "The field " + field.getName() + " in the " + clazz.getSimpleName() + " is using the @" + annotation.getSimpleName() 
				+ " annotation, its type is " + type.getSimpleName() 
				+ ", however it is not in the list of valid types (list: " + concatedListValidTypes.toString() + "): .\n";
	}
	
	@Override	
	public String validateField(Class<?> clazz, Field field){
		String error = "";
		
		if(field.isAnnotationPresent(annotation)){
			
			Class<?> type = field.getType();
						
			ValidFieldTypes fvf = field.getAnnotation(annotation);			
			Class[] listValidTypes = fvf.listValidTypes();
			
			boolean found = false;
			for(Class<?> oneValidType: listValidTypes){	
								
				if(type.isPrimitive() && type.toString().equals(oneValidType.toString()))
					found = true;
				
//				List -> List // String -> String
				else if(type.isAssignableFrom(oneValidType))				
					found = true;
				
//				List -> ArrayList
				else if(oneValidType.isAssignableFrom(type))
					found = true;
				
			}
			
			if(!found)			
				error = getErrorMessage(clazz, field, type, listValidTypes);		
						
		}
		
		return error;
	}
}
