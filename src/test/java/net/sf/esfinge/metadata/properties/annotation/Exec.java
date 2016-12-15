package net.sf.esfinge.metadata.properties.annotation;

import net.sf.esfinge.metadata.annotation.validator.SearchInsideAnnotations;
import net.sf.esfinge.metadata.annotation.validator.SearchOnEnclosingElements;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@SearchOnEnclosingElements
@SearchInsideAnnotations
public @interface Exec {
	
}
