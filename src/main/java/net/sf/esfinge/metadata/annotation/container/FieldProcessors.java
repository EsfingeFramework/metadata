package net.sf.esfinge.metadata.annotation.container;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import net.sf.esfinge.metadata.container.reading.FieldProcessorsReadingProcessor;

@Retention(RetentionPolicy.RUNTIME)
@AnnotationReadingConfig(FieldProcessorsReadingProcessor.class)
public @interface FieldProcessors {
	Class<? extends Annotation> value();
}
