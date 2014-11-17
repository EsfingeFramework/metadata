package org.esfinge.metadata.locate;

import java.lang.annotation.*;

import org.esfinge.metadata.annotation.SearchOnEnclosingElements;

@SearchOnEnclosingElements
@Retention(RetentionPolicy.RUNTIME)
public @interface FindMePackage {

}
