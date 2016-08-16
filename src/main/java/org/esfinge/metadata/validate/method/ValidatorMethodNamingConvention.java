package org.esfinge.metadata.validate.method;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
			
			Pattern pattern = Pattern.compile(regexNamingConvencion);
	        Matcher matcher = pattern.matcher(methodsName);
	 
	        if( ! matcher.find() ){				
				String error = getErrorMessage(classConcrete, 
												method, 
												toValidate.annotationType());
				throw new AnnotationValidationException(error);				
			}
						
		}	
		
	}
			
	private String getErrorMessage(Class<?> classConcrete, 
									Method method,			
									Class<? extends Annotation> classOfAnnotationInField) {		
		
		return "The method " + method.getName() + " in the " + classConcrete.getSimpleName() 
				+ " is using the @" + classOfAnnotationInField.getSimpleName() 
				+ " annotation, however it is not match with " 
				+ "the regex naming convencion: " + regexNamingConvencion + ".";
	}
}
