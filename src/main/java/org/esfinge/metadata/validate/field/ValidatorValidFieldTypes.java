package org.esfinge.metadata.validate.field;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;

import org.esfinge.metadata.AnnotationValidationException;
import org.esfinge.metadata.AnnotationValidator;
import org.esfinge.metadata.annotation.validator.field.ValidFieldTypes;

public class ValidatorValidFieldTypes implements AnnotationValidator {
	
	private Class<?>[] listValidTypes = {};
	
	@Override
	public void initialize(Annotation self) {		
		ValidFieldTypes vft = (ValidFieldTypes) self;		
		listValidTypes = vft.listValidTypes();				
	}

	@Override
	public void validate(Annotation toValidate, 
							AnnotatedElement annotated)
									throws AnnotationValidationException {
		
		if(annotated instanceof Field){			
			Field field = (Field) annotated;						
			Class<?> classConcrete = field.getDeclaringClass(); 
						
			Class<?> type = field.getType();
						
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
				String error = getErrorMessage(classConcrete, 
												field, 
												toValidate.annotationType(), 
												type, 
												listValidTypes);				
				throw new AnnotationValidationException(error);
			}			
		}
		
	}	
	
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
	
}
