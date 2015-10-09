package org.esfinge.metadata.validate;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.esfinge.metadata.annotation.ToValidate;

public class MetadataValidator {

	public static void validateMetadataOn(Class<?> clazz) throws AnnotationValidationException{

		for(Annotation an : clazz.getAnnotations()){
			validateAnnotation(an, clazz);
		}
		
		Class<?> currentClazz = clazz;
		
		while(currentClazz != Object.class){
			for(Method m : currentClazz.getDeclaredMethods()){
				for(Annotation an : m.getAnnotations()){
					validateAnnotation(an, m);
				}
			}
			for(Field f : currentClazz.getDeclaredFields()){
				for(Annotation an : f.getAnnotations()){
					validateAnnotation(an, f);
				}
			}
			//TODO: pegar construtores também....
			
			currentClazz = currentClazz.getSuperclass();
		}
		
		
	}
	
	private static void validateAnnotation(Annotation target, AnnotatedElement ae) throws AnnotationValidationException{
		for(Annotation an: target.annotationType().getAnnotations()){
			if(an.annotationType().isAnnotationPresent(ToValidate.class)){
				ToValidate tovalidate = an.annotationType().getAnnotation(ToValidate.class);
				Class<? extends AnnotationValidator> validClazz = tovalidate.validationClass();
				
				AnnotationValidator av;
				
				try {
					av = validClazz.newInstance();
				} catch (Exception e) {
					throw new RuntimeException("The AnnotationValidator needs to have an non-args public constructor",e);
				}
				
				av.initialize(an);
				av.validate(target, ae);
				
			// exclui anotações predefinidas do Java
			}else if(!an.annotationType().getPackage().getName().equals("java.lang.annotation")){
				validateAnnotation(an, ae);
			}
		}
	}

}
