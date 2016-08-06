package org.esfinge.metadata.foo.validator.implementation;

import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
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
	
	private String verifyValidAnnotation(Class<?> classConcrete, 
										AccessibleObject fieldOrMethod,
										Class<? extends Annotation> classOfAnnotation, 
										Class<? extends Annotation> classOfSubAnnotation) 
												throws Exception {	
		
		Class<?> classFieldOrMethod = fieldOrMethod.getClass();
		
		String error = "";
		StringBuilder errorsBuilder = new StringBuilder();	
		
		for(ValidatorInterface vi: validators){			
			error = "";			
			
			if(classFieldOrMethod.isAssignableFrom(Field.class)){
				
				error = vi.verifyValidAnnotationInField(classConcrete, 
														(Field) fieldOrMethod, 
														classOfAnnotation, 
														classOfSubAnnotation);	
				
			} else if(classFieldOrMethod.isAssignableFrom(Method.class)){
				
				error = vi.verifyValidAnnotationInMethod(classConcrete, 
															(Method) fieldOrMethod, 
															classOfAnnotation, 
															classOfSubAnnotation);
			}else{
				throw new Exception("The parameter is not Field or Method.");
			}			
			
			if(!error.equals(""))						
				errorsBuilder.append(error + "\n");
		}
		
		return errorsBuilder.toString();
	}
		
	@Override
	public String verifyValidAnnotationInField(Class<?> classConcrete, 
										Field field,
										Class<? extends Annotation> classOfAnnotationInField, 
										Class<? extends Annotation> classOfSubAnnotation) {
		String error = "";
		try {
			error = verifyValidAnnotation(classConcrete, 
											field,
											classOfAnnotationInField, 
											classOfSubAnnotation);
		} catch (Exception e) {
			e.printStackTrace();
			error = e.getMessage();
		}
				
		return error;
	}

	@Override
	public String verifyValidAnnotationInMethod(Class<?> classConcrete,
												Method method,
												Class<? extends Annotation> classOfAnnotationInMethod, 
												Class<? extends Annotation> classOfSubAnnotation) {
		String error = "";
		try {
			error = verifyValidAnnotation(classConcrete, 
											method,
											classOfAnnotationInMethod, 
											classOfSubAnnotation);
		} catch (Exception e) {
			e.printStackTrace();
			error = e.getMessage();
		}		
		
		return error;		
	}
	
	
	
	
	
//	@Override
//	public String verifyValidAnnotationInField(Class<?> classConcrete, 
//										Field field,
//										Class<? extends Annotation> classOfAnnotationInField, 
//										Class<? extends Annotation> classOfSubAnnotation) {
//		String error = "";
//		StringBuilder errorsBuilder = new StringBuilder();	
//		
//		for(ValidatorInterface vi: validators){	
//			error = "";
//			error = vi.verifyValidAnnotation(classConcrete, 
//											field, 
//											classOfAnnotationInField, 
//											classOfSubAnnotation);	
//			
//			if(!error.equals(""))						
//				errorsBuilder.append(error + "\n");
//		}
//		
//		return errorsBuilder.toString();
//	}
//
//	@Override
//	public String verifyValidAnnotationInMethod(Class<?> classConcrete,
//												Method method,
//												Class<? extends Annotation> classOfAnnotationInMethod, 
//												Class<? extends Annotation> classOfSubAnnotation) {		
//		String error = "";
//		StringBuilder errorsBuilder = new StringBuilder();	
//		
//		for(ValidatorInterface vi: validators){	
//			error = "";
//			error = vi.verifyValidAnnotationInMethod(classConcrete, 
//														method, 
//														classOfAnnotationInMethod, 
//														classOfSubAnnotation);	
//			if(!error.equals(""))						
//				errorsBuilder.append(error + "\n");
//		}
//		
//		return errorsBuilder.toString();
//		
//	}

	
}
