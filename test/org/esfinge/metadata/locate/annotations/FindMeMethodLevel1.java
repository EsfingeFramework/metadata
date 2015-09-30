package org.esfinge.metadata.locate.annotations;


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.esfinge.metadata.validate.needsToHave.SearchOnEnclosingElements;

@FindMeMethod
@SearchOnEnclosingElements
@Retention(RetentionPolicy.RUNTIME)
public @interface FindMeMethodLevel1 {

}