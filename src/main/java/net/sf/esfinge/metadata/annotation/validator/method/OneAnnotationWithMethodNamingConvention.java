package net.sf.esfinge.metadata.annotation.validator.method;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@MethodNamingConvention(regexNamingConvencion = "^get")
@Retention(RetentionPolicy.RUNTIME)
public @interface OneAnnotationWithMethodNamingConvention {
}
