package org.esfinge.metadata.foo.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class ValidateStaticFieldOnly {
	
	public static boolean validateStaticFieldOnly(Object someObject){

		Class<?> clazz = someObject.getClass();
		
		Field[] declaredFields = clazz.getDeclaredFields();  // get all the fields
		
		for(Field field: declaredFields){
			
//			field.setAccessible(true);	
			
			if(field.isAnnotationPresent(StaticFieldOnly.class)){
				System.out.println(">>>" + field.getName());
//				System.out.println(field.getType());
//				System.out.println(field.getModifiers());
				String modifiers = Modifier.toString(field.getModifiers());
				System.out.println(modifiers);
//				System.out.println(field.getGenericType());
				System.out.println("\n\n");
			}			
		}
			
//		Field[] fields = clazz.getFields();  // get all public fields
//		for(Field field: fields){			
//			field.setAccessible(true);						
//			if(field.isAnnotationPresent(StaticFieldOnly.class)){
//				System.out.println(">>>" + field.getName());
//				System.out.println(field.getType());
//				System.out.println(field.getModifiers());
//				System.out.println(field.getGenericType());
//				System.out.println("\n\n");
//			}			
//		}

		return true;
	}

}
