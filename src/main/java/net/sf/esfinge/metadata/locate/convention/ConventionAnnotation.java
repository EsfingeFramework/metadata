package net.sf.esfinge.metadata.locate.convention;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(value=ElementType.ANNOTATION_TYPE)
public @interface ConventionAnnotation {
	Class<? extends ConventionProcessor> value();
}
