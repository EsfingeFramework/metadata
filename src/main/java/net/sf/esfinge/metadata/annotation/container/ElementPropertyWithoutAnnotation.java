package net.sf.esfinge.metadata.annotation.container;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import net.sf.esfinge.metadata.annotation.finder.SearchOnEnclosingElements;
import net.sf.esfinge.metadata.container.reading.ElementPropertyWithoutAnnotationReadingProcessor;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@AnnotationReadingConfig(ElementPropertyWithoutAnnotationReadingProcessor.class)
@SearchOnEnclosingElements

public @interface ElementPropertyWithoutAnnotation {
	Class<? extends Annotation> value();
}
