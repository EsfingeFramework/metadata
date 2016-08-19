package net.sf.esfinge.metadata.annotation.container.field;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import net.sf.esfinge.metadata.annotation.validator.field.StaticFieldOnly;

@StaticFieldOnly
@Retention(RetentionPolicy.RUNTIME)
public @interface OneAnnotationWithStaticFieldOnly {
}
