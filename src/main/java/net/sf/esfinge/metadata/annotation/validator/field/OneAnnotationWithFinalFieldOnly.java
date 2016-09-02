package net.sf.esfinge.metadata.annotation.validator.field;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@FinalFieldOnly
@Retention(RetentionPolicy.RUNTIME)
public @interface OneAnnotationWithFinalFieldOnly {
}
