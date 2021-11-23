package net.sf.esfinge.metadata.locate.conventions.annotations;
import net.sf.esfinge.metadata.locate.conventions.MethodParamOfTypeConventionVerifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
@Verifier(MethodParamOfTypeConventionVerifier.class)
public @interface MethodParamOfTypeConvention {
    Class<?>[] parameters();
    boolean canBeSubtype() default false;
}
