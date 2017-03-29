package net.sf.esfinge.metadata.annotation.container;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import net.sf.esfinge.metadata.annotation.finder.SearchInsideAnnotations;
import net.sf.esfinge.metadata.container.AnnotationReadingProcessor;
import net.sf.esfinge.metadata.validate.needsToHave.SearchOnEnclosingElements;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
@SearchOnEnclosingElements
@SearchInsideAnnotations
public @interface AnnotationReadingConfig {
	Class<? extends AnnotationReadingProcessor> value();
}
