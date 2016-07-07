package org.esfinge.metadata.annotation.container;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.esfinge.metadata.annotation.validator.ValidFieldType;
import org.esfinge.metadata.container.reading.AnnotationPropertyReadingProcessor;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@AnnotationReadingConfig(AnnotationPropertyReadingProcessor.class)
@ValidFieldType({String.class})
public @interface AnnotationProperty {
	Class<? extends Annotation> annotation();
	String property();
	
}
