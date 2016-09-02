package net.sf.esfinge.containerProcessosrsTest;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.AnnotatedElement;

@Retention(RetentionPolicy.RUNTIME)
public @interface InitProcessor {

	Class<?> value();
}
