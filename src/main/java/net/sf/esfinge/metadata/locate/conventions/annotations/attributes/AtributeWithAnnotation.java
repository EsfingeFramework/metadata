package net.sf.esfinge.metadata.locate.conventions.annotations.attributes;

import java.lang.annotation.Annotation;

public @interface AtributeWithAnnotation {
    Class<? extends Annotation> value();
}
