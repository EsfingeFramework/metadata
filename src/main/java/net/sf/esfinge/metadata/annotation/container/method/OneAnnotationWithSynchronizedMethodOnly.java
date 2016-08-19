package net.sf.esfinge.metadata.annotation.container.method;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import net.sf.esfinge.metadata.annotation.validator.method.SynchronizedMethodOnly;

@SynchronizedMethodOnly
@Retention(RetentionPolicy.RUNTIME)
public @interface OneAnnotationWithSynchronizedMethodOnly {
}
