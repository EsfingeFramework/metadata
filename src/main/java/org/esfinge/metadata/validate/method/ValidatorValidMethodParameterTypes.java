package org.esfinge.metadata.validate.method;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;

import org.esfinge.metadata.AnnotationValidationException;
import org.esfinge.metadata.AnnotationValidator;
import org.esfinge.metadata.annotation.validator.method.Parameters;
import org.esfinge.metadata.annotation.validator.method.ValidMethodParameterTypes;

public class ValidatorValidMethodParameterTypes implements AnnotationValidator {
	
	private Parameters[] validParameters = null;
	
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
												parametersTypes);
				throw new AnnotationValidationException(error);
			}			
		}
		
	}	
	
	private boolean isValidParameters(Class<?>[] parametersTypesOfMethod) {		
		int countParametersOfMethod = parametersTypesOfMethod.length;
		
		for(Parameters oneValidParameters: validParameters){			
			Class<?>[] validParametersClasses = oneValidParameters.parameters();
			
			if(countParametersOfMethod == validParametersClasses.length && 
					isParametersOfMethodInValidParameters(parametersTypesOfMethod, 
															validParametersClasses))
					return true;
		}

		return false;
	}
	
	public boolean isParametersOfMethodInValidParameters(Class<?>[] parametersTypesOfMethod, 
															Class<?>[] validParametersClasses){		
		
		boolean invalid = false;
		for(int i = 0; i < parametersTypesOfMethod.length; i++){

			if(!validParametersClasses[i].isAssignableFrom(parametersTypesOfMethod[i]))
				invalid = true;					
		}

		if(invalid) return false;
		
		return true;		
	}
	
	
	
	
	
//	public boolean isParametersOfMethodInValidParameters(Class<?>[] parametersTypesOfMethod, 
//															Class<?>[] validParametersClasses){
//		
//		for(Class<?> parameterTypeOfMethod : parametersTypesOfMethod){
//			
////			parameterTypeOfMethod in validParametersClasses ?					
//			if( in(parameterTypeOfMethod, validParametersClasses) )
//				return true;
//		}
//		
//		return false;		
//	}
//	
//	
//	public boolean in(Class<?> parameterTypeOfMethod, Class<?>[] validParametersClasses){
//		
//		for(Class<?> validParameter: validParametersClasses){
//			
//			if(validParameter.isAssignableFrom(parameterTypeOfMethod))
//				return true;			
//		}
//		
//		return false;		
//	}
	

	
	public String getErrorMessage(Class<?> clazz, 
									Method method, 
									Class<? extends Annotation> classOfAnnotationInField,
									Class<?>[] parametersTypes){
		
		StringBuilder concatedParameterTypes = new StringBuilder();
		concatedParameterTypes.append("[");
		for(Class<?> oneParameter: parametersTypes){
			concatedParameterTypes.append(oneParameter.getSimpleName());
			concatedParameterTypes.append(", ");
		}
		concatedParameterTypes.append("]");		
		
		
		StringBuilder concatedListTypes = new StringBuilder();
		concatedListTypes.append("[");
		for(Parameters parameter: validParameters){
			
			Class<?>[] parameters = parameter.parameters();		
			
			for(Class<?> oneParameter: parameters){				
				concatedListTypes.append(oneParameter.getSimpleName());
				concatedListTypes.append(", ");				
			}
			
			concatedListTypes.append(" , ");
		}
		concatedListTypes.append("]");	
		
		
		return "The method " + method.getName() + " in the " + clazz.getSimpleName() 
				+ " is using the @" + classOfAnnotationInField.getSimpleName() 
				+ " annotation, its parameters are " + concatedParameterTypes.toString() 
				+ ", however it is not in the list of valid parameters: " + concatedListTypes.toString() + ".";
	}
	
}
