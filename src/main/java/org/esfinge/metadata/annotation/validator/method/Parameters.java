package org.esfinge.metadata.annotation.validator.method;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Parameters {
	Class<?>[] parameters();
}
