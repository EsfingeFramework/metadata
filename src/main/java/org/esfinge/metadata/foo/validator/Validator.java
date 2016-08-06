package org.esfinge.metadata.foo.validator;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

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
	
	

}
