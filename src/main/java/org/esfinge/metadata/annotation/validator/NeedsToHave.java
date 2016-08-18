package org.esfinge.metadata.annotation.validator;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.esfinge.metadata.validate.NeedToHaveAnnotationValidator;

@ToValidate(validationClass = NeedToHaveAnnotationValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
public @interface NeedsToHave {
	public Class<? extends Annotation> value();
}
