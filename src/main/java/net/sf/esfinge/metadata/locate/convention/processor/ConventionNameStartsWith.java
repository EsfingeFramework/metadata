package net.sf.esfinge.metadata.locate.convention.processor;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import net.sf.esfinge.metadata.locate.convention.ConventionAnnotation;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
@ConventionAnnotation(PrefixConventionProcessor.class)
public @interface ConventionNameStartsWith {
	String prefix();
}
