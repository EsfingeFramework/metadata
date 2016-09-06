package net.sf.esfinge.metadata.annotation.validator.method;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@SynchronizedMethodOnly
@Retention(RetentionPolicy.RUNTIME)
public @interface OneAnnotationWithSynchronizedMethodOnly {
}
