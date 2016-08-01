package org.esfinge.metadata.foo.validator.implementation;

import java.lang.reflect.Field;

import org.esfinge.metadata.foo.annotation.ValidFieldTypes;
import org.esfinge.metadata.foo.validator.ValidatorInterface;

public class ValidatorValidFieldTypes implements ValidatorInterface {
	
	private Class<ValidFieldTypes> annotation = ValidFieldTypes.class;
	
	public String getErrorMessage(Class<?> clazz, Field field, Class<?> type, String[] listValidTypes){
		
		StringBuilder concatedListValidTypes = new StringBuilder();
		concatedListValidTypes.append("[");
		for(String oneValidType: listValidTypes){
			concatedListValidTypes.append(oneValidType);
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
			String[] listValidTypes = fvf.listValidTypes();
			
			boolean found = false;
			for(String oneValidType: listValidTypes){	
				
				if(type.isPrimitive() && type.toString().equals(oneValidType.toString()))
					found = true;
				
//				List -> List
//				List -> ArrayList
				else if(type.isAssignableFrom(oneValidType.getClass()))				
					found = true;
				
//				List -> List
//				ArrayList -> List
				else if(oneValidType.getClass().isAssignableFrom(type))
					found = true;
				
			}
			
			if(!found)			
				error = getErrorMessage(clazz, field, type, listValidTypes);		
						
		}
		
		return error;
	}
}
