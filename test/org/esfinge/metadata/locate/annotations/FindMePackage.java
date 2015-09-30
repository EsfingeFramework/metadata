package org.esfinge.metadata.locate.annotations;

import java.lang.annotation.*;

import org.esfinge.metadata.validate.needsToHave.SearchOnEnclosingElements;
@SearchOnEnclosingElements
@Retention(RetentionPolicy.RUNTIME)
public @interface FindMePackage {

}
