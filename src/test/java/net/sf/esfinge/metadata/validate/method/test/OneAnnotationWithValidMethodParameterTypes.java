package net.sf.esfinge.metadata.validate.method.test;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import net.sf.esfinge.metadata.annotation.validator.method.Parameters;
import net.sf.esfinge.metadata.annotation.validator.method.ValidMethodParameterTypes;

@ValidMethodParameterTypes(
		validParameters = {
			@Parameters( parameters = {String.class, Integer.class} ), 
			@Parameters( parameters = {String.class, int.class} )
		}
)
@Retention(RetentionPolicy.RUNTIME)
public @interface OneAnnotationWithValidMethodParameterTypes {
}
