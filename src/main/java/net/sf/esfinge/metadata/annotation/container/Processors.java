package net.sf.esfinge.metadata.annotation.container;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;

import net.sf.esfinge.metadata.container.reading.ReflectionReferenceReadingProcessor;

@Retention(RUNTIME)
@AnnotationReadingConfig(ReflectionReferenceReadingProcessor.class)
public @interface Processors {
	Class<? extends Annotation> value();
}
