package net.sf.esfinge.metadata.annotation.container;

import java.lang.annotation.*;
import java.lang.annotation.Annotation;

import net.sf.esfinge.metadata.annotation.validator.ValidFieldType;
import net.sf.esfinge.metadata.container.reading.ContainsAnnotationReadingProcessor;
import net.sf.esfinge.metadata.validate.needsToHave.SearchOnEnclosingElements;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@AnnotationReadingConfig(ContainsAnnotationReadingProcessor.class)
@ValidFieldType({Boolean.class,boolean.class})
@SearchOnEnclosingElements

public @interface ContainsAnnotation {
	Class<? extends Annotation> value();
}
