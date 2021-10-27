package net.sf.esfinge.metadata.locate.conventions.annotations;

import net.sf.esfinge.metadata.locate.conventions.ClassHaveTypeConventionVerifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
@Verifier(ClassHaveTypeConventionVerifier.class)
public @interface ClassHaveTypeConvention {
    Class<?> classType();
    boolean canBeSubtype() default false;
}
