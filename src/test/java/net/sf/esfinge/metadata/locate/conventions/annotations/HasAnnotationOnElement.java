package net.sf.esfinge.metadata.locate.conventions.annotations;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@HaveAnnotationOnElementConvention(annotationClass = Deprecated.class)
public @interface HasAnnotationOnElement {
}
