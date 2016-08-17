package org.esfinge.metadata.annotation.validator.method;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.esfinge.metadata.annotation.validator.ToValidate;
import org.esfinge.metadata.validate.method.ValidatorMethodVisibilityRequired;

@ToValidate(validationClass = ValidatorMethodVisibilityRequired.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
public @interface MethodVisibilityRequired {
	String itNeedsToHaveThisVisibility();
}
