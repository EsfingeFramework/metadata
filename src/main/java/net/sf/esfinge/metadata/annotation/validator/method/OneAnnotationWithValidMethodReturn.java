package net.sf.esfinge.metadata.annotation.validator.method;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@ValidMethodReturn(validTypesToReturn = {int.class, Integer.class})
@Retention(RetentionPolicy.RUNTIME)
public @interface OneAnnotationWithValidMethodReturn {
}
