package org.esfinge.metadata.foo.annotation.fieldonly;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
public @interface FinalFieldOnly {
	boolean ignoreWhenNotField() default true;
}
