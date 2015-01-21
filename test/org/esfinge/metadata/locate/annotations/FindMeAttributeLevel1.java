package org.esfinge.metadata.locate.annotations;


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.esfinge.metadata.annotation.SearchOnEnclosingElements;

@FindMeAttribute
@SearchOnEnclosingElements
@Retention(RetentionPolicy.RUNTIME)
public @interface FindMeAttributeLevel1 {

}