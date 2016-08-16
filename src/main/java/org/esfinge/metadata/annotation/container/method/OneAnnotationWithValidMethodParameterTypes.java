package org.esfinge.metadata.annotation.container.method;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.esfinge.metadata.annotation.validator.method.ValidMethodParameterTypes;

@ValidMethodParameterTypes(validParameters = {String.class, int.class})
//@ValidMethodParameterTypes(validParameters = {{String.class, Integer.class}, {String.class, int.class}})
@Retention(RetentionPolicy.RUNTIME)
public @interface OneAnnotationWithValidMethodParameterTypes {
}
