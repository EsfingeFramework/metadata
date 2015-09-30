package org.esfinge.metadata.locate.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.esfinge.metadata.validate.needsToHave.SearchInsideAnnotations;
import org.esfinge.metadata.validate.needsToHave.SearchOnEnclosingElements;

@Transaction
@SearchOnEnclosingElements
@SearchInsideAnnotations
@Retention(RetentionPolicy.RUNTIME)
public @interface Administration {

}
