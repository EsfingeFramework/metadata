package org.esfinge.metadata.annotation.container.field;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.esfinge.metadata.annotation.validator.field.TransientFieldOnly;

@TransientFieldOnly
@Retention(RetentionPolicy.RUNTIME)
public @interface OneAnnotationWithTransientFieldOnly {
}
