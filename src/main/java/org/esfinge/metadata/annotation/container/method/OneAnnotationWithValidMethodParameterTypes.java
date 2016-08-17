package org.esfinge.metadata.annotation.container.method;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.esfinge.metadata.annotation.validator.method.Parameters;
import org.esfinge.metadata.annotation.validator.method.ValidMethodParameterTypes;

@ValidMethodParameterTypes(
		validParameters = {
			@Parameters( parameters = {String.class, Integer.class} ), 
			@Parameters( parameters = {String.class, int.class} )
		}
)
@Retention(RetentionPolicy.RUNTIME)
public @interface OneAnnotationWithValidMethodParameterTypes {
}
