package net.sf.esfinge.metadata.annotation.validator.method;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@MethodVisibilityForbidden(itCannotHaveThisVisibility = "private")
@Retention(RetentionPolicy.RUNTIME)
public @interface OneAnnotationWithMethodVisibilityForbidden {
}
