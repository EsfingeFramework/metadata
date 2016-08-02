package org.esfinge.metadata.foo.validator.old;

import java.lang.reflect.Field;

public interface ValidatorInterface {
		
	public String validateField(Class<?> clazz, Field field);

}
