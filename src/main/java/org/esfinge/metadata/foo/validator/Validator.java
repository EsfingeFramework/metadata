package org.esfinge.metadata.foo.validator;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.esfinge.metadata.foo.validator.implementation.ValidatorAll;

public class Validator {
	
	private ValidatorInterface vi;
	private StringBuilder errorsBuilder = new StringBuilder();
	
	public Validator(){
		this.vi = new ValidatorAll();		
	}
	
	public Validator(ValidatorInterface vi){
		this.vi = vi;		
	}
	
	public void setValidator(ValidatorInterface vi) {
		this.vi = vi;
	}
	
	public ValidatorInterface getValidator() {
		return vi;
	}
	
	public boolean validateAnnotationInObject(Object someObject) throws Exception{
		Class<?> classConcrete = someObject.getClass();		
		
		this.verifyAllFields(classConcrete);
//		this.verifyAllMethods(classConcrete);
		
		String errors = this.errorsBuilder.toString();
		if(!errors.equals(""))
			throw new Exception(errors);
		
		return true;
	}

	private void verifyAllFields(Class<?> classConcrete) {
		String error = "";
		Field[] declaredFields = classConcrete.getDeclaredFields();
		
		for(Field field: declaredFields){				
			Annotation[] annotationsInField = field.getAnnotations();
			
			for(Annotation annotationInField: annotationsInField){				
				Class<? extends Annotation> classOfAnnotationInField = annotationInField.annotationType();
				Annotation[] annotationsInAnnotation = classOfAnnotationInField.getAnnotations();				
				
				for(Annotation annotationInAnnotation: annotationsInAnnotation){			
					Class<? extends Annotation> classOfSubAnnotation = annotationInAnnotation.annotationType();
					
					error = "";
					error = this.vi.verifyValidAnnotation(classConcrete, 
															field, 
															classOfAnnotationInField, 
															classOfSubAnnotation);					
					if(!error.equals(""))						
						this.errorsBuilder.append(error + "\n");
					
				}
				
			}		

					
		}

	}
	
//	private void verifyAllMethods(Class<?> classConcrete) {
//		String error = "";
//		Method[] declaredMethods = classConcrete.getDeclaredMethods();
//		
//		for(Method method: declaredMethods){				
//			Annotation[] annotationsInMethod = method.getAnnotations();
//			
//			for(Annotation annotationInMethod: annotationsInMethod){				
//				Class<? extends Annotation> classOfAnnotationInMethod = annotationInMethod.annotationType();
//				Annotation[] annotationsInAnnotation = classOfAnnotationInMethod.getAnnotations();				
//				
//				for(Annotation annotationInAnnotation: annotationsInAnnotation){			
//					Class<? extends Annotation> classOfSubAnnotation = annotationInAnnotation.annotationType();
//					
//					error = "";
//					error = this.vi.verifyValidAnnotationInMethod(classConcrete, 
//															method, 
//															classOfAnnotationInMethod, 
//															classOfSubAnnotation);					
//					if(!error.equals(""))						
//						this.errorsBuilder.append(error + "\n");
//					
//				}
//				
//			}		
//
//					
//		}
//
//	}
	
	

}
