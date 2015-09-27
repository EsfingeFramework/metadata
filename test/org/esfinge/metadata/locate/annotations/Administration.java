package org.esfinge.metadata.locate.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.esfinge.metadata.annotation.SearchOnEnclosingElements;

@Transaction
@SearchOnEnclosingElements
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Administration {

}
