package net.sf.esfinge.metadata.validate.method.test;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import net.sf.esfinge.metadata.annotation.validator.method.ForbiddenMethodReturn;

@ForbiddenMethodReturn(invalidTypesToReturn = {void.class, float.class})
@Retention(RetentionPolicy.RUNTIME)
public @interface OneAnnotationWithForbiddenMethodReturn {
}
