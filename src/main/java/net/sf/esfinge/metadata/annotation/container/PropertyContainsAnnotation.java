package net.sf.esfinge.metadata.annotation.container;

import java.lang.annotation.Annotation;

import net.sf.esfinge.metadata.container.reading.ProcessorsReadingProcessor;
import net.sf.esfinge.metadata.container.reading.PropertyContainsAnnotationProcessor;
@AnnotationReadingConfig(PropertyContainsAnnotationProcessor.class)

public @interface PropertyContainsAnnotation {
	Class<? extends Annotation> value();

}
