package net.sf.esfinge.metadata.annotation.container;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import net.sf.esfinge.metadata.annotation.finder.SearchInsideAnnotations;
import net.sf.esfinge.metadata.container.ContainerTarget;
import net.sf.esfinge.metadata.container.reading.FieldProcessorsReadingProcessor;

@Retention(RetentionPolicy.RUNTIME)
@AnnotationReadingConfig(FieldProcessorsReadingProcessor.class)
@SearchInsideAnnotations
@ContainerFor(ContainerTarget.TYPE)
public @interface FieldProcessors {
	Class<? extends Annotation> value();
	ProcessorType type() default ProcessorType.READER_IS_PROCESSOR;
}
