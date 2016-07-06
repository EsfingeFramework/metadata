package org.esfinge.metadata.annotation.container;

import java.lang.annotation.*;

import org.esfinge.metadata.container.reading.ContainsAnnotationReadingProcessor;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@AnnotationReadingConfig(ContainsAnnotationReadingProcessor.class)
public @interface ContainsAnnotation {
	Class<? extends Annotation> value();
}
