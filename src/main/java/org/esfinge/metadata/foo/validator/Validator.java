package org.esfinge.metadata.foo.validator;

import java.lang.reflect.Field;

public class Validator {
		
	private ValidatorInterface vi;
	
	public Validator(ValidatorInterface vi){
		this.vi = vi;		
	}
	
	public boolean validateAnnotationInObject(Object someObject) throws Exception{
		StringBuilder errorsBuilder = new StringBuilder();

		Class<?> clazz = someObject.getClass();		
		Field[] declaredFields = clazz.getDeclaredFields();
		
		for(Field field: declaredFields){			
			String error = vi.validateField(clazz, field);
			
			if(!error.equals(""))						
				errorsBuilder.append(error + "\n");			
		}
		
		String errors = errorsBuilder.toString();
		if(!errors.equals(""))
			throw new Exception(errors);
		
		return true;
	}

}
