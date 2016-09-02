package net.sf.esfinge.metadata.annotation.validator.method;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@ValidNumberOfParameters(numberOfParameters = 2)
@Retention(RetentionPolicy.RUNTIME)
public @interface OneAnnotationWithValidNumberOfParameters {
}
