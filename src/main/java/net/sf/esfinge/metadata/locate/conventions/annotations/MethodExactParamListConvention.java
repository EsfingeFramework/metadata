package net.sf.esfinge.metadata.locate.conventions.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import net.sf.esfinge.metadata.locate.conventions.MethodExactParamListConventionVerifier;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
@Verifier(MethodExactParamListConventionVerifier.class)
public @interface MethodExactParamListConvention {
    Class<?>[] parameters();
}
