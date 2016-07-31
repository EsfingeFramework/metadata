package org.esfinge.metadata.foo.validator;

import java.lang.reflect.Field;

public interface ValidatorInterface {
		
	public String validateField(Class<?> clazz, Field field);

}
