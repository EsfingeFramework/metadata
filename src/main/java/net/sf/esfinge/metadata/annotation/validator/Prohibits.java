package net.sf.esfinge.metadata.annotation.validator;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import net.sf.esfinge.metadata.validate.ProhibitsAnnotationValidator;

@ToValidate(validationClass = ProhibitsAnnotationValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
public @interface Prohibits {
	public Class<? extends Annotation> value();
}
