package org.esfinge.metadata.locate.annotations;

import java.lang.annotation.*;

import org.esfinge.metadata.validate.NeedsToHave;

@NeedsToHave(Transaction.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface Logging {

}
