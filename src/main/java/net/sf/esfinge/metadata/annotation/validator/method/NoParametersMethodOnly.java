package net.sf.esfinge.metadata.annotation.validator.method;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import net.sf.esfinge.metadata.annotation.validator.ToValidate;
import net.sf.esfinge.metadata.validate.method.ValidatorNoParametersMethodOnly;

@ToValidate(validationClass = ValidatorNoParametersMethodOnly.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
public @interface NoParametersMethodOnly {
}
