package net.sf.esfinge.metadata.annotation.container;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import net.sf.esfinge.metadata.container.reading.ProcessorsReadingProcessor;
import net.sf.esfinge.metadata.validate.needsToHave.SearchOnEnclosingElements;

@Retention(RUNTIME)
@AnnotationReadingConfig(ProcessorsReadingProcessor.class)
@SearchOnEnclosingElements

public @interface Processors {
	Class<? extends Annotation> value();
	ProcessorType type() default ProcessorType.READER_IS_PROCESSOR;
}
