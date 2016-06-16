package org.esfinge.metadata.locate.annotationLocator;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;

import org.esfinge.metadata.annotation.SearchInsideAnnotations;
import org.esfinge.metadata.annotation.SearchOnEnclosingElements;

@SearchOnEnclosingElements
@SearchInsideAnnotations
@Retention(RetentionPolicy.RUNTIME)
public @interface Transaction01 {

}
