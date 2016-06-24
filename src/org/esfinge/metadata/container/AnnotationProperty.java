package org.esfinge.metadata.container;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.esfinge.metadata.container.reading.AnnotationPropertyReadingProcessor;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@AnnotationReadingConfig(AnnotationPropertyReadingProcessor.class)
public @interface AnnotationProperty {
	Class<? extends Annotation> annotation();
	String property();
	
}
