package net.sf.esfinge.metadata.annotation.validator.field;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@VolatileFieldOnly
@Retention(RetentionPolicy.RUNTIME)
public @interface OneAnnotationWithVolatileFieldOnly {
}
