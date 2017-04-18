package net.sf.esfinge.metadata.annotation.container;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;

import net.sf.esfinge.metadata.annotation.finder.SearchInsideAnnotations;
import net.sf.esfinge.metadata.container.reading.PropertyProcessorsReadingProcessor;
import net.sf.esfinge.metadata.annotation.finder.SearchOnEnclosingElements;




@Retention(RUNTIME)
@AnnotationReadingConfig(PropertyProcessorsReadingProcessor.class)
@SearchInsideAnnotations
@SearchOnEnclosingElements

public @interface PropertyProcessors {

	Class<? extends Annotation> value();
	ProcessorType type() default ProcessorType.READER_ADDS_METADATA;

}
