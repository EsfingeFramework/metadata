package net.sf.esfinge.metadata.validate.prohibits;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import net.sf.esfinge.metadata.annotation.validator.Prohibits;
@Prohibits(Finalize.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface Init {

}
