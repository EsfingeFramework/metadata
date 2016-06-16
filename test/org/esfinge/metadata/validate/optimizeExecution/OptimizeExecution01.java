package org.esfinge.metadata.validate.optimizeExecution;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.esfinge.metadata.annotation.Prohibits;
import org.esfinge.metadata.annotation.SearchInsideAnnotations;
import org.esfinge.metadata.annotation.SearchOnEnclosingElements;

@SearchOnEnclosingElements
@SearchInsideAnnotations
@Prohibits(Logging01.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface OptimizeExecution01 {

}