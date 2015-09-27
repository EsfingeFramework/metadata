package org.esfinge.metadata.locate.annotations;

import java.lang.annotation.*;

import org.esfinge.metadata.annotation.SearchOnEnclosingElements;
import org.esfinge.metadata.validate.NeedsToHave;
import org.esfinge.metadata.validate.Transaction;

@NeedsToHave(Transaction.class)
@SearchOnEnclosingElements
@Retention(RetentionPolicy.RUNTIME)
public @interface Logging {

}
