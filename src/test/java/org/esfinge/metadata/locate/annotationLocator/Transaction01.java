package org.esfinge.metadata.locate.annotationLocator;
import java.lang.annotation.RetentionPolicy;

import org.esfinge.metadata.annotation.validator.SearchInsideAnnotations;
import org.esfinge.metadata.annotation.validator.SearchOnEnclosingElements;

import java.lang.annotation.Retention;

@SearchOnEnclosingElements
@SearchInsideAnnotations
@Retention(RetentionPolicy.RUNTIME)
public @interface Transaction01 {

}
