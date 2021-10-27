package net.sf.esfinge.metadata.locate.conventions.annotations;
import net.sf.esfinge.metadata.locate.conventions.MethodTypeConventionVerifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
@Verifier(MethodTypeConventionVerifier.class)
public @interface MethodTypeConvention {
    Class<?>[] parameters();
}
