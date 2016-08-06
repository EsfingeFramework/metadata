package org.esfinge.metadata.foo.validator.implementation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.esfinge.metadata.foo.validator.ValidatorInterface;

public class ValidatorAll implements ValidatorInterface {
	
	private List<ValidatorInterface> validators;
	
	public ValidatorAll() {		
		validators = new ArrayList<ValidatorInterface>();
		
		validators.add(new ValidatorFieldOnly());		
		validators.add(new ValidatorInstanceFieldOnly());
		validators.add(new ValidatorFieldVisibilityForbidden());
		validators.add(new ValidatorFieldVisibilityRequired());
		validators.add(new ValidatorValidFieldTypes());	
	}
		
	@Override
	public String verifyValidAnnotation(Class<?> classConcrete, Field field,
										Class<? extends Annotation> classOfAnnotationInField, 
										Class<? extends Annotation> classOfSubAnnotation) {
		String error = "";
		StringBuilder errorsBuilder = new StringBuilder();	
		
		for(ValidatorInterface vi: validators){	
			error = "";
			error = vi.verifyValidAnnotation(classConcrete, 
											field, 
											classOfAnnotationInField, 
											classOfSubAnnotation);	
			
			if(!error.equals(""))						
				errorsBuilder.append(error + "\n");
		}
		
		return errorsBuilder.toString();
	}

	@Override
	public String verifyValidAnnotationInMethod(Class<?> classConcrete,
												Method method,
												Class<? extends Annotation> classOfAnnotationInMethod, 
												Class<? extends Annotation> classOfSubAnnotation) {		
		String error = "";
		StringBuilder errorsBuilder = new StringBuilder();	
		
		for(ValidatorInterface vi: validators){	
			error = "";
			error = vi.verifyValidAnnotationInMethod(classConcrete, 
														method, 
														classOfAnnotationInMethod, 
														classOfSubAnnotation);	
			if(!error.equals(""))						
				errorsBuilder.append(error + "\n");
		}
		
		return errorsBuilder.toString();
		
	}

	
}
