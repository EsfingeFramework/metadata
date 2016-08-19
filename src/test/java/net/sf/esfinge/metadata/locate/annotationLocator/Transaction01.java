package net.sf.esfinge.metadata.locate.annotationLocator;
import java.lang.annotation.RetentionPolicy;

import net.sf.esfinge.metadata.annotation.validator.SearchInsideAnnotations;
import net.sf.esfinge.metadata.annotation.validator.SearchOnEnclosingElements;

import java.lang.annotation.Retention;

@SearchOnEnclosingElements
@SearchInsideAnnotations
@Retention(RetentionPolicy.RUNTIME)
public @interface Transaction01 {

}
