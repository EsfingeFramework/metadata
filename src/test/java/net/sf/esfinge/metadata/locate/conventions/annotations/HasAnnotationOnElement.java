package net.sf.esfinge.metadata.locate.conventions.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@HaveAnnotationOnElementConvention(annotationClass = Override.class,elementClass = Method.class)
public @interface HasAnnotationOnElement {
}
