package net.sf.esfinge.metadata.properties.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import net.sf.esfinge.metadata.annotation.validator.SearchInsideAnnotations;
import net.sf.esfinge.metadata.annotation.validator.SearchOnEnclosingElements;

@Retention(RetentionPolicy.RUNTIME)
@SearchOnEnclosingElements
@SearchInsideAnnotations
public @interface PropertyAnnotation {

}
