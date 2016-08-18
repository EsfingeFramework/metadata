package org.esfinge.metadata.validate.method;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;

import org.esfinge.metadata.AnnotationValidationException;
import org.esfinge.metadata.AnnotationValidator;

public class ValidatorNoParametersMethodOnly implements AnnotationValidator {
		
	@Override
	public void initialize(Annotation self) {
	}

	@Override
	public void validate(Annotation toValidate, 
							AnnotatedElement annotated)
									throws AnnotationValidationException {		
		
		if(annotated instanceof Method){			
			Method method = (Method) annotated;						
			Class<?> classConcrete = method.getDeclaringClass();  // ex.: Person.class
									
			int countParameters = method.getParameterCount();
			
			if(countParameters != 0){
				String error = getErrorMessage(classConcrete, 
												method, 
												toValidate.annotationType(),
												countParameters);
				throw new AnnotationValidationException(error);				
			}			
						
		}

	}
		
	private String getErrorMessage(Class<?> classConcrete, 
									Method method,			
									Class<? extends Annotation> classOfAnnotationInField,
									int countParameters) {
		
		return "The method " + method.getName() + " in the " + classConcrete.getSimpleName() 
					+ " is using the @" + classOfAnnotationInField.getSimpleName() 
					+ " annotation, its parameters count are: " + countParameters 
					+ ", however it needs to have 0 parameters.";
	}
}
