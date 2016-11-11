package net.sf.esfinge.metadata.annotation.container;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;

import net.sf.esfinge.metadata.container.reading.PropertyProcessorsProcessorsReadingProcessor;

@Retention(RUNTIME)
@AnnotationReadingConfig(PropertyProcessorsProcessorsReadingProcessor.class)

public @interface PropertyProcessors {

	Class<? extends Annotation> value();

}
