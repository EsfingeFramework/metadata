package net.sf.esfinge.metadata.annotation.validator.method;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@MethodVisibilityRequired(itNeedsToHaveThisVisibility = "protected")
@Retention(RetentionPolicy.RUNTIME)
public @interface OneAnnotationWithMethodVisibilityRequired {
}
