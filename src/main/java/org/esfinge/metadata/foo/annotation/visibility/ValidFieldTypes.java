package org.esfinge.metadata.foo.annotation.visibility;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
public @interface ValidFieldTypes {
	Class<?>[] listValidTypes();
	boolean ignoreWhenNotField() default true;
}
