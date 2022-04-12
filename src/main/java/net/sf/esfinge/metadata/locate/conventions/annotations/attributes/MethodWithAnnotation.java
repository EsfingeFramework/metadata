package net.sf.esfinge.metadata.locate.conventions.annotations.attributes;

import java.lang.annotation.Annotation;

public @interface MethodWithAnnotation {
    Class<? extends Annotation> value();
}
