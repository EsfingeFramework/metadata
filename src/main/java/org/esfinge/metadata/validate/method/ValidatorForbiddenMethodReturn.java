package org.esfinge.metadata.validate.method;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;

import org.esfinge.metadata.AnnotationValidationException;
import org.esfinge.metadata.AnnotationValidator;
import org.esfinge.metadata.annotation.validator.method.ForbiddenMethodReturn;

public class ValidatorForbiddenMethodReturn implements AnnotationValidator {
	
	private Class<?>[] listInvalidTypes = {};
	
	@Override
	public void initialize(Annotation self) {		
		ForbiddenMethodReturn fmr = (ForbiddenMethodReturn) self;		
		listInvalidTypes = fmr.invalidTypesToReturn();				
	}

	@Override
	public void validate(Annotation toValidate, 
							AnnotatedElement annotated)
									throws AnnotationValidationException {
		
		if(annotated instanceof Method){			
			Method method = (Method) annotated;						
			Class<?> classConcrete = method.getDeclaringClass(); 
						
			Class<?> type = method.getReturnType();
						
			boolean found = false;
			for(Class<?> oneValidType: listInvalidTypes){	
								
//				if(type.isPrimitive() && type.toString().equals(oneValidType.toString()))
//					found = true;				
////				List -> List // String -> String
//				else if(type.isAssignableFrom(oneValidType))				
//					found = true;				
////				List -> ArrayList
//				else if(oneValidType.isAssignableFrom(type))
//					found = true;
				
				if(oneValidType.isAssignableFrom(type))
					found = true;
				
			}
			
			if(found){			
				String error = getErrorMessage(classConcrete, 
												method, 
												toValidate.annotationType(), 
												type, 
												listInvalidTypes);				
				throw new AnnotationValidationException(error);
			}			
		}
		
	}	
	
	public String getErrorMessage(Class<?> clazz, 
									Method method, 
									Class<? extends Annotation> classOfAnnotationInField,
									Class<?> type, 
									Class<?>[] listInvalidTypes){
		
		StringBuilder concatedListTypes = new StringBuilder();
		concatedListTypes.append("[");
		for(Class<?> oneType: listInvalidTypes){
			concatedListTypes.append(oneType.getSimpleName());
			concatedListTypes.append(", ");
		}
		concatedListTypes.append("]");
		
		return "The method " + method.getName() + " in the " + clazz.getSimpleName() 
				+ " is using the @" + classOfAnnotationInField.getSimpleName() 
				+ " annotation, its return type is " + type.getSimpleName() 
				+ ", however it is in the list of invalid types (list: " + concatedListTypes.toString() + ") .";
	}
	
}
