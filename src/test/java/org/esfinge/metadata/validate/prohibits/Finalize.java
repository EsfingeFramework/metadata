package org.esfinge.metadata.validate.prohibits;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.esfinge.metadata.annotation.validator.Prohibits;
import org.esfinge.metadata.annotation.validator.SearchOnEnclosingElements;
@Prohibits(Init.class)
@SearchOnEnclosingElements
@Retention(RetentionPolicy.RUNTIME)
public @interface Finalize {

}
