package org.esfinge.metadata.foo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.esfinge.metadata.foo.annotation.fieldonly.TransientFieldOnly;

@TransientFieldOnly
@Retention(RetentionPolicy.RUNTIME)
//@Target(ElementType.FIELD)
public @interface OneAnnotationWithTransientFieldOnly {
}
