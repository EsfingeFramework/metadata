package net.sf.esfinge.metadata.locate.conventions.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import net.sf.esfinge.metadata.locate.conventions.FieldTypeConventionVerifier;
import net.sf.esfinge.metadata.locate.conventions.PrefixConventionVerifier;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
@Verifier(FieldTypeConventionVerifier.class)
public @interface FieldTypeConvention {
	Class<?> type();
	boolean canBeSubtype() default false;
}
