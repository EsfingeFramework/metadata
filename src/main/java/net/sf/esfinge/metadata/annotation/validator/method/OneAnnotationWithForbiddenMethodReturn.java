package net.sf.esfinge.metadata.annotation.validator.method;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@ForbiddenMethodReturn(invalidTypesToReturn = {void.class, float.class})
@Retention(RetentionPolicy.RUNTIME)
public @interface OneAnnotationWithForbiddenMethodReturn {
}
