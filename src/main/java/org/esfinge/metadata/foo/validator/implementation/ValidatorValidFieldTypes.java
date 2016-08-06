package org.esfinge.metadata.foo.validator.implementation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.esfinge.metadata.foo.annotation.fieldonly.InstanceFieldOnly;
import org.esfinge.metadata.foo.annotation.visibility.ValidFieldTypes;
import org.esfinge.metadata.foo.validator.ValidatorInterface;

public class ValidatorValidFieldTypes implements ValidatorInterface {
	
	private Class<ValidFieldTypes> annotation = ValidFieldTypes.class;
	
	public String getErrorMessage(Class<?> clazz, 
									Field field, 
									Class<? extends Annotation> classOfAnnotationInField,
									Class<?> type, 
									Class<?>[] listValidTypes){
		
		StringBuilder concatedListValidTypes = new StringBuilder();
		concatedListValidTypes.append("[");
		for(Class<?> oneValidType: listValidTypes){
			concatedListValidTypes.append(oneValidType.getSimpleName());
			concatedListValidTypes.append(", ");
		}
		concatedListValidTypes.append("]");
		
		return "The field " + field.getName() + " in the " + clazz.getSimpleName() 
				+ " is using the @" + classOfAnnotationInField.getSimpleName() 
				+ " annotation, its type is " + type.getSimpleName() 
				+ ", however it is not in the list of valid types (list: " + concatedListValidTypes.toString() + "): .\n";
	}
	
	@Override	
	public String verifyValidAnnotation(Class<?> classConcrete, Field field,
										Class<? extends Annotation> classOfAnnotationInField, 
										Class<? extends Annotation> classOfSubAnnotation) {
		
		String error = "";
		
		if(classOfAnnotationInField.isAnnotationPresent(annotation)
												&& classOfSubAnnotation.equals(annotation)){
			
			Class<?> type = field.getType();
						
			ValidFieldTypes fvf = classOfAnnotationInField.getAnnotation(annotation);			
			Class<?>[] listValidTypes = fvf.listValidTypes();
			
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
			
			if(!found){			
				error = getErrorMessage(classConcrete, 
										field, 
										classOfAnnotationInField, 
										type, 
										listValidTypes);
			}
			
						
		}
		
		return error;
	}
		
	@Override
	public String verifyValidAnnotationInMethod(Class<?> classConcrete,
												Method method,
												Class<? extends Annotation> classOfAnnotationInMethod, 
												Class<? extends Annotation> classOfSubAnnotation) {
		
		String error = "";
		
		if(classOfAnnotationInMethod.isAnnotationPresent(annotation)
													&& classOfSubAnnotation.equals(annotation)){			
			
			ValidFieldTypes vft = classOfAnnotationInMethod.getAnnotation(annotation);			
			boolean ignoreWhenNotField = vft.ignoreWhenNotField();
			
			if(!ignoreWhenNotField){
				
				System.out.println("Verifying in method... ValidFieldTypes");
				
			}else{
				
				System.out.println("Ignoring in method... ValidFieldTypes");
				
			}
			
		}		
		
		return error;
	}
	
	
}
