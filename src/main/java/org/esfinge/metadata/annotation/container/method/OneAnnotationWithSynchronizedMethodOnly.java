package org.esfinge.metadata.annotation.container.method;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.esfinge.metadata.annotation.validator.method.SynchronizedMethodOnly;

@SynchronizedMethodOnly
@Retention(RetentionPolicy.RUNTIME)
public @interface OneAnnotationWithSynchronizedMethodOnly {
}
