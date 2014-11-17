package org.esfinge.metadata.validate;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@NeedsToHave(A.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface B {

}
