package org.esfinge.metadata.foo.validator;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import org.esfinge.metadata.foo.validator.ValidatorInterface;

public class Validator {
	
	private ValidatorInterface vi;
	
	public Validator(ValidatorInterface vi){
		this.vi = vi;		
	}
	
	public boolean validateAnnotationInObject(Object someObject) throws Exception{
		String error = "";
		StringBuilder errorsBuilder = new StringBuilder();		

		Class<?> classConcrete = someObject.getClass();		
		Field[] declaredFields = classConcrete.getDeclaredFields();
		
		for(Field field: declaredFields){				
			Annotation[] annotationsInField = field.getAnnotations();
			
			for(Annotation annotationInField: annotationsInField){				
				Class<? extends Annotation> classOfAnnotationInField = annotationInField.annotationType();
				Annotation[] annotationsInAnnotation = classOfAnnotationInField.getAnnotations();				
				
				for(Annotation annotationInAnnotation: annotationsInAnnotation){			
					Class<? extends Annotation> classOfSubAnnotation = annotationInAnnotation.annotationType();
					
					error = vi.verifyValidAnnotation(classConcrete, 
														field, 
														classOfAnnotationInField, 
														classOfSubAnnotation);
					
					if(!error.equals(""))						
						errorsBuilder.append(error + "\n");	
				}
				
			}		

					
		}
		
		String errors = errorsBuilder.toString();
		if(!errors.equals(""))
			throw new Exception(errors);
		
		return true;
	}


}
