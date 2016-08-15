package org.esfinge.metadata.validate.method;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;

import org.esfinge.metadata.AnnotationValidationException;
import org.esfinge.metadata.AnnotationValidator;
import org.esfinge.metadata.annotation.validator.method.MethodNamingConvention;

public class ValidatorMethodNamingConvention implements AnnotationValidator {
	
	private String regexNamingConvencion = "";
	
	@Override
	public void initialize(Annotation self) {		
		MethodNamingConvention mnc = (MethodNamingConvention) self;		
		regexNamingConvencion = mnc.regexNamingConvencion();	
	}

	@Override
	public void validate(Annotation toValidate, 
							AnnotatedElement annotated)
									throws AnnotationValidationException {
		
		if(annotated instanceof Method){			
			Method method = (Method) annotated;						
			Class<?> classConcrete = method.getDeclaringClass();  // ex.: Person.class
						
			String methodsName = method.getName();
			
			if(!methodsName.contains(regexNamingConvencion)){				
				String error = getErrorMessage(classConcrete, method, 
												toValidate.annotationType(), 
												methodsName);
				throw new AnnotationValidationException(error);				
			}
						
		}	
		
	}
			
	private String getErrorMessage(Class<?> classConcrete, 
									Method method,			
									Class<? extends Annotation> classOfAnnotationInField,
									String methodsName) {		
		
		return "The method " + method.getName() + " in the " + classConcrete.getSimpleName() 
				+ " is using the @" + classOfAnnotationInField.getSimpleName() 
				+ " annotation, however it is not match with " 
				+ "the regex naming convencion: " + regexNamingConvencion + ".";
	}
}
