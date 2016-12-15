package net.sf.esfinge.metadata.annotation.container;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import net.sf.esfinge.metadata.container.reading.PropertyContainsAnnotationProcessor;



@Retention(RetentionPolicy.RUNTIME)
@AnnotationReadingConfig(PropertyContainsAnnotationProcessor.class)
public @interface PropertyContainsAnnotation {
	Class<? extends Annotation> value();

}
