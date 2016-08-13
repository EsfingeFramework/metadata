package org.esfinge.metadata.annotation.container.method;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.esfinge.metadata.annotation.validator.method.MethodVisibilityForbidden;

@MethodVisibilityForbidden(itCannotHaveThisVisibility = "private")
@Retention(RetentionPolicy.RUNTIME)
//@Target(ElementType.METHOD)
public @interface OneAnnotationWithMethodVisibilityForbidden {
}
