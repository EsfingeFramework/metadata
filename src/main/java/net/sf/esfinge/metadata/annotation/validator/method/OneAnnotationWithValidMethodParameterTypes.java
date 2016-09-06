package net.sf.esfinge.metadata.annotation.validator.method;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@ValidMethodParameterTypes(
		validParameters = {
			@Parameters( parameters = {String.class, Integer.class} ), 
			@Parameters( parameters = {String.class, int.class} )
		}
)
@Retention(RetentionPolicy.RUNTIME)
public @interface OneAnnotationWithValidMethodParameterTypes {
}
