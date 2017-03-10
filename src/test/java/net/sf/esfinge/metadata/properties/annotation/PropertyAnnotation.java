package net.sf.esfinge.metadata.properties.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import net.sf.esfinge.metadata.annotation.finder.SearchInsideAnnotations;
import net.sf.esfinge.metadata.annotation.finder.SearchOnEnclosingElements;

@Retention(RetentionPolicy.RUNTIME)
@SearchOnEnclosingElements
@SearchInsideAnnotations
public @interface PropertyAnnotation {

}
