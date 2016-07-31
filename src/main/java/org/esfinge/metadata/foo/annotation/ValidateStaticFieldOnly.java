package org.esfinge.metadata.foo.annotation;

import java.lang.reflect.Field;

public class ValidateStaticFieldOnly {
	
	public static boolean validateStaticFieldOnly(Object someObject){

		Class<?> clazz = someObject.getClass();
		
		Field[] fields = clazz.getFields();
				
		for(Field field: fields){
						
			if(field.isAnnotationPresent(StaticFieldOnly.class)){
				System.out.println(">>>" + field.getName());
				System.out.println(field.getType());
				System.out.println(field.getModifiers());
				System.out.println(field.getGenericType());
				System.out.println("\n\n");
			}
			
		}
		
		
		return true;
	}

}
