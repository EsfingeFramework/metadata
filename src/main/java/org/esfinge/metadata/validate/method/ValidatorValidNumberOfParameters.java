package org.esfinge.metadata.validate.method;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;

import org.esfinge.metadata.AnnotationValidationException;
import org.esfinge.metadata.AnnotationValidator;
import org.esfinge.metadata.annotation.validator.method.ValidNumberOfParameters;

public class ValidatorValidNumberOfParameters implements AnnotationValidator {
	
	private int numberOfParameters = 0;
	
	@Override
	public void initialize(Annotation self) {
		ValidNumberOfParameters vnp = (ValidNumberOfParameters) self;		
		numberOfParameters = vnp.numberOfParameters();	
	}

	@Override
	public void validate(Annotation toValidate, 
							AnnotatedElement annotated)
									throws AnnotationValidationException {		
		
		if(annotated instanceof Method){			
			Method method = (Method) annotated;						
			Class<?> classConcrete = method.getDeclaringClass();  // ex.: Person.class
									
			int countParameters = method.getParameterCount();
			
			if(countParameters != numberOfParameters){
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
					+ ", however it needs to have " + numberOfParameters + " parameters.";
	}
	
}
