package org.esfinge.metadata.validate.optimizeExecution;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.esfinge.metadata.annotation.validator.Prohibits;
import org.esfinge.metadata.annotation.validator.SearchInsideAnnotations;
import org.esfinge.metadata.annotation.validator.SearchOnEnclosingElements;

@SearchOnEnclosingElements
@SearchInsideAnnotations
@Prohibits(Logging01.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface OptimizeExecution01 {

}