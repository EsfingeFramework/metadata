package org.esfinge.metadata.annotation.container.field;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.esfinge.metadata.annotation.validator.field.FinalFieldOnly;

@FinalFieldOnly
@Retention(RetentionPolicy.RUNTIME)
//@Target(ElementType.FIELD)
public @interface OneAnnotationWithFinalFieldOnly {
}
