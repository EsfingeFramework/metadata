package org.esfinge.metadata.validate;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.esfinge.metadata.AnnotationPropertyValidator;
import org.esfinge.metadata.AnnotationValidationException;
import org.esfinge.metadata.AnnotationValidator;
import org.esfinge.metadata.annotation.validator.ToValidate;
import org.esfinge.metadata.annotation.validator.ToValidateProperty;

public class MetadataValidator {
	public static void validateMetadataOn(Class<?> clazz) throws AnnotationValidationException{

		for(Annotation an : clazz.getAnnotations()){
			validateAnnotation(an, clazz);
		}
		
		Class<?> currentClazz = clazz;
		
		while(currentClazz != Object.class && currentClazz!=null){
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
			
			for(Constructor<?> c : currentClazz.getConstructors()){
				for(Annotation an : c.getAnnotations()){
					validateAnnotation(an, c);
				}
			}						
				
			currentClazz = currentClazz.getSuperclass();
		}		
	}
	
	private static void validateAnnotation(Annotation target, AnnotatedElement ae) throws AnnotationValidationException{				
		
		for(Annotation an: target.annotationType().getAnnotations()){			
			if(an.annotationType().isAnnotationPresent(ToValidate.class)){				
				executeValidation(target, ae, an);								
			}else if(!isJavaAnnotation(an) && !isEsfingeMetadataAnnotation(an)){				
				validateAnnotation(an, ae);						
			}
		}
		
		for(Method m : target.annotationType().getMethods()){
			for(Annotation an: m.getAnnotations()){	
				if(isEsfingeMetadataAnnotation(an)){
					executePropertyValidation(target, ae, an, m);
				}
			}
		}
	}
	
	private static AnnotationPropertyValidator executePropertyValidation(Annotation target,
			AnnotatedElement ae, Annotation an, Method m)
			throws AnnotationValidationException {
		
		ToValidateProperty tovalidate = an.annotationType().getAnnotation(ToValidateProperty.class);
		
		Class<? extends AnnotationPropertyValidator> validClazz = tovalidate.validationClass();
		
		AnnotationPropertyValidator apv;
		
		Object o = null;
		try {
			o = m.invoke(target);
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalArgumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InvocationTargetException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		/*System.out.println("target:"+target.toString());
		System.out.println("anotElement:"+ae.toString());
		System.out.println("an:"+an.toString());
		System.out.println("m:"+m.getName());
		
		System.out.println("pointToUser: "+o.toString());
		
		*/
		
		Object oo = null;
		try {
			Class<?> c = an.annotationType();
			
			for (Method mm : c.getDeclaredMethods()) {
				 oo = mm.invoke(an);
			}
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalArgumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InvocationTargetException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//System.out.println("MinValue: "+oo.toString());
		
		
		try {
			apv = validClazz.newInstance();
		} catch (Exception e) {
			throw new RuntimeException("The AnnotationPropertyValidator needs to have an non-args public constructor",e);
		}
										
		apv.initialize(an);
		apv.validate(target, ae, m, o);
		return apv;
		
	}
	
	private static AnnotationValidator executeValidation(Annotation target,
			AnnotatedElement ae, Annotation an)
			throws AnnotationValidationException {
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
		return av;
	}

	// exclui anotacoes predefinidas do Java
	private static boolean isJavaAnnotation(Annotation an) {
		return an.annotationType().getPackage().getName().equals("java.lang.annotation");
	}

	private static boolean isEsfingeMetadataAnnotation(Annotation an) {
		return an.annotationType().getPackage().getName().equals("org.esfinge.metadata.annotation.validator");
	}	
}
