package org.esfinge.metadata.annotation.container.method;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.esfinge.metadata.annotation.validator.method.MethodVisibilityRequired;

@MethodVisibilityRequired(itNeedsToHaveThisVisibility = "protected")
@Retention(RetentionPolicy.RUNTIME)
//@Target(ElementType.METHOD)
public @interface OneAnnotationWithMethodVisibilityRequired {
}
