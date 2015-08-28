package org.esfinge.metadata.validate;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.esfinge.metadata.annotation.SearchOnEnclosingElements;

@NeedsToHave(Transaction.class)
@SearchOnEnclosingElements
@Retention(RetentionPolicy.RUNTIME)
public @interface Logging {

}
