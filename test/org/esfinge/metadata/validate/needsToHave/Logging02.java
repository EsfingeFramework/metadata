package org.esfinge.metadata.validate.needsToHave;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.esfinge.metadata.validate.NeedsToHave;

@NeedsToHave(Transaction02.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface Logging02 {

}
