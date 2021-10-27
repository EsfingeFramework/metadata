package net.sf.esfinge.metadata.locate.conventions.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import net.sf.esfinge.metadata.locate.conventions.ClassOfGivenTypeConventionVerifier;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
@Verifier(ClassOfGivenTypeConventionVerifier.class)
public @interface ClassOfGivenTypeConvention {
    Class<?> superClass();
    boolean canBeSubtype() default false;
}
