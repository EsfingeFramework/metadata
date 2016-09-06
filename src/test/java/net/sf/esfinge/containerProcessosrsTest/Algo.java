package net.sf.esfinge.containerProcessosrsTest;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Algo {
	Class<?> value();
}
