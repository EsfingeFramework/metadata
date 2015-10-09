package org.esfinge.metadata.locate.annotationLocator;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.esfinge.metadata.validate.needsToHave.SearchInsideAnnotations;
import org.esfinge.metadata.validate.needsToHave.SearchOnEnclosingElements;

@Transaction01
@SearchOnEnclosingElements
@SearchInsideAnnotations
@Retention(RetentionPolicy.RUNTIME)
public @interface Administration01 {

}
