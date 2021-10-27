package net.sf.esfinge.metadata.locate.conventions.annotations;

import net.sf.esfinge.metadata.locate.conventions.ClassHaveAnnotationConventionVerifier;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
@Verifier(ClassHaveAnnotationConventionVerifier.class)
public @interface ClassHaveAnnotationConvention {
    Class<?>[] classAnnotations();
}
