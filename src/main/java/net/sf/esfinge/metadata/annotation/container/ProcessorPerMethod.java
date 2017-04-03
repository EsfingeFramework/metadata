package net.sf.esfinge.metadata.annotation.container;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import net.sf.esfinge.metadata.container.reading.MethodProcessorsReadingProcessor;
import net.sf.esfinge.metadata.annotation.finder.SearchOnEnclosingElements;

@Retention(RetentionPolicy.RUNTIME)
@AnnotationReadingConfig(MethodProcessorsReadingProcessor.class)
@SearchOnEnclosingElements

public @interface ProcessorPerMethod {
	Class<? extends Annotation> configAnnotation();
	ProcessorType type() default ProcessorType.READER_IS_PROCESSOR;

}
