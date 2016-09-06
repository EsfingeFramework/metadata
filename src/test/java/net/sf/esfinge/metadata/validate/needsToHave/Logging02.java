package net.sf.esfinge.metadata.validate.needsToHave;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import net.sf.esfinge.metadata.annotation.validator.NeedsToHave;

@NeedsToHave(Transaction02.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface Logging02 {

}
