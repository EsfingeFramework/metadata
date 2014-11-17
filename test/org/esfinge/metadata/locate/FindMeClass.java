package org.esfinge.metadata.locate;
import java.lang.annotation.RetentionPolicy;

import java.lang.annotation.Retention;

import org.esfinge.metadata.annotation.SearchOnEnclosingElements;

@SearchOnEnclosingElements
@Retention(RetentionPolicy.RUNTIME)
public @interface FindMeClass {

}
