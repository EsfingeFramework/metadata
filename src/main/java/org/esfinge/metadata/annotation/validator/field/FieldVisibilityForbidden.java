package org.esfinge.metadata.annotation.validator.field;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.esfinge.metadata.annotation.validator.ToValidate;
import org.esfinge.metadata.validate.field.ValidatorFieldVisibilityForbidden;

@ToValidate(validationClass = ValidatorFieldVisibilityForbidden.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
public @interface FieldVisibilityForbidden {
	String itCannotHaveThisVisibility();
	boolean ignoreWhenNotField() default true;	
}
