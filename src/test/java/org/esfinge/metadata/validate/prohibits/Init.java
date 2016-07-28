package org.esfinge.metadata.validate.prohibits;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.esfinge.metadata.annotation.validator.Prohibits;
@Prohibits(Finalize.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface Init {

}
