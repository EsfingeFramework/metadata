package org.esfinge.metadata.locate.annotations;

import java.lang.annotation.*;

import org.esfinge.metadata.validate.NeedsToHave;
import org.esfinge.metadata.validate.needsToHave.SearchOnEnclosingElements;
import org.esfinge.metadata.validate.needsToHave.Transaction01;

@NeedsToHave(Transaction01.class)
@SearchOnEnclosingElements
@Retention(RetentionPolicy.RUNTIME)
public @interface Logging {

}
