package org.esfinge.metadata.foo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.esfinge.metadata.foo.annotation.visibility.FieldVisibilityForbidden;

@FieldVisibilityForbidden(itCannotHaveThisVisibility = "public")
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface OneAnnotationWithFieldVisibilityForbidden {
}
