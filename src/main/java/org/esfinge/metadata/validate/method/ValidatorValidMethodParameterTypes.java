package org.esfinge.metadata.validate.method;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;

import org.esfinge.metadata.AnnotationValidationException;
import org.esfinge.metadata.AnnotationValidator;
import org.esfinge.metadata.annotation.validator.method.ValidMethodParameterTypes;

public class ValidatorValidMethodParameterTypes implements AnnotationValidator {
	
	private Class<?>[] validParameters = null;
	
	@Override
	public void initialize(Annotation self) {		
		ValidMethodParameterTypes vmpt = (ValidMethodParameterTypes) self;		
		validParameters = vmpt.validParameters();	
	}

	@Override
	public void validate(Annotation toValidate, 
							AnnotatedElement annotated)
									throws AnnotationValidationException {
		
		if(annotated instanceof Method){			
			Method method = (Method) annotated;						
			Class<?> classConcrete = method.getDeclaringClass(); 
						
			Class<?>[] parametersTypes = method.getParameterTypes();			
						
			if(!isValidParameters(parametersTypes)){			
				String error = getErrorMessage(classConcrete, 
												method, 
												toValidate.annotationType(), 
												parametersTypes, 
												validParameters);				
				throw new AnnotationValidationException(error);
			}			
		}
		
	}

	private boolean isValidParameters(Class<?>[] parametersTypesOfMethod) {

		for(Class<?> oneValidParameter: validParameters){	
										
			boolean found = false;
			for(Class<?> parameterTypeOfMethod: parametersTypesOfMethod){
				
				if(oneValidParameter.isAssignableFrom(parameterTypeOfMethod)){
					found = true; 
					break;				
				}
			}
			
			if(!found)
				return false;
		}
		
		return true;
	}	
	
	public String getErrorMessage(Class<?> clazz, 
									Method method, 
									Class<? extends Annotation> classOfAnnotationInField,
									Class<?>[] parametersTypes, 
									Class<?>[] listInvalidTypes){
		
		StringBuilder concatedParameterTypes = new StringBuilder();
		concatedParameterTypes.append("[");
		for(Class<?> oneParameter: parametersTypes){
			concatedParameterTypes.append(oneParameter.getSimpleName());
			concatedParameterTypes.append(", ");
		}
		concatedParameterTypes.append("]");		
		
		StringBuilder concatedListTypes = new StringBuilder();
		concatedListTypes.append("[");
		for(Class<?> oneType: listInvalidTypes){
			concatedListTypes.append(oneType.getSimpleName());
			concatedListTypes.append(", ");
		}
		concatedListTypes.append("]");		
		
		return "The method " + method.getName() + " in the " + clazz.getSimpleName() 
				+ " is using the @" + classOfAnnotationInField.getSimpleName() 
				+ " annotation, its parameters are " + concatedParameterTypes.toString() 
				+ ", however it is not in the list of valid parameters: " + concatedListTypes.toString() + ".";
	}
	
}
