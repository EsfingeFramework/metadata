package net.sf.esfinge.metadata.validate.method.test;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import net.sf.esfinge.metadata.annotation.validator.method.StaticMethodOnly;

@StaticMethodOnly
@Retention(RetentionPolicy.RUNTIME)
public @interface OneAnnotationWithStaticMethodOnly {
}
