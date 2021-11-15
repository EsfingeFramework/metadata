package net.sf.esfinge.metadata.locate.conventions.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@RegularExpressionConvention("Regex")
@Retention(RetentionPolicy.RUNTIME)
public @interface HasRegex {
}
