package org.esfinge.metadata.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.esfinge.metadata.validate.RefersToAnnotationValidator;

@ToValidateProperty(validationClass = RefersToAnnotationValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
public @interface RefersTo {
	public Class<? extends Annotation> annotation();
	String attributeValue();
}
