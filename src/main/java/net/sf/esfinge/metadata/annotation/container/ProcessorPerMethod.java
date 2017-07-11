package net.sf.esfinge.metadata.annotation.container;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import net.sf.esfinge.metadata.annotation.finder.SearchOnEnclosingElements;
import net.sf.esfinge.metadata.container.reading.MethodProcessorsReadingProcessor;

@Retention(RetentionPolicy.RUNTIME)
@AnnotationReadingConfig(MethodProcessorsReadingProcessor.class)
@SearchOnEnclosingElements

public @interface ProcessorPerMethod {
	Class<? extends Annotation> configAnnotation();
	ProcessorType type() default ProcessorType.READER_ADDS_METADATA;

}
