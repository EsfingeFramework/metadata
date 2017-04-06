package net.sf.esfinge.metadata.annotation.container;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;

import net.sf.esfinge.metadata.annotation.finder.SearchOnEnclosingElements;
import net.sf.esfinge.metadata.container.reading.ProcessorsReadingProcessor;

@Retention(RUNTIME)
@AnnotationReadingConfig(ProcessorsReadingProcessor.class)
@SearchOnEnclosingElements
public @interface CustomReader {
	Class<? extends Annotation> configAnnotation();
	ProcessorType type() default ProcessorType.READER_ADD_PROCESSOR;
	String readerConfig() default "value";
}
