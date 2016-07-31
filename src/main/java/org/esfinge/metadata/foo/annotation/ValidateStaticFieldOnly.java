package org.esfinge.metadata.foo.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class ValidateStaticFieldOnly {
	
	public static boolean validateStaticFieldOnly(Object someObject) throws Exception{
				
		StringBuilder errorsBuilder = new StringBuilder();

		Class<?> clazz = someObject.getClass();		
		Field[] declaredFields = clazz.getDeclaredFields();
		
		for(Field field: declaredFields){
									
			if(field.isAnnotationPresent(StaticFieldOnly.class)){
				String modifiers = Modifier.toString(field.getModifiers());
				
				if(!modifiers.contains("static")){					
					if(modifiers.equals("")) modifiers = "default";
					
					String error = "The field " + field.getName() + " in the " + clazz 
							+ " is using the @StaticFieldOnly annotation, however it has no static modifier.\n"
							+ "(it has just this(these) modifier(s): " + modifiers + " )";
					
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
