package net.sf.esfinge.metadata.annotation.validator.field;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@FieldVisibilityRequired(itNeedsToHaveThisVisibility = "private")
@Retention(RetentionPolicy.RUNTIME)
public @interface OneAnnotationWithFieldVisibilityRequired {
}
