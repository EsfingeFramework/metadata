package org.esfinge.metadata.validate;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.esfinge.metadata.annotation.SearchOnEnclosingElements;
import org.esfinge.metadata.validate.NeedsToHave;

@NeedsToHave(Transaction.class)
@SearchOnEnclosingElements
@Retention(RetentionPolicy.RUNTIME)
public @interface Logging {

}
