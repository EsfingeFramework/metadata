package net.sf.esfinge.metadata.locate.conventions.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import net.sf.esfinge.metadata.locate.conventions.ConventionVerifier;

@Target(ElementType.ANNOTATION_TYPE)
@Retention(RetentionPolicy.RUNTIME)

public @interface Verifier {
	Class<? extends ConventionVerifier> value();
}
