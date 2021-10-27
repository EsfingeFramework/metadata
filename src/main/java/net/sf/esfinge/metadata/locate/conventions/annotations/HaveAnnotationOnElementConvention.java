package net.sf.esfinge.metadata.locate.conventions.annotations;

import java.lang.annotation.*;
import java.lang.annotation.Annotation;
import net.sf.esfinge.metadata.locate.conventions.HaveAnnotationOnElementConventionVerifier;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
@Verifier(HaveAnnotationOnElementConventionVerifier.class)
public @interface HaveAnnotationOnElementConvention {
    Class<?> annotationClass();
    Class<?> elementClass();
}
