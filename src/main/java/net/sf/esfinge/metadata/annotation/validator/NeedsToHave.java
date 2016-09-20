package net.sf.esfinge.metadata.annotation.validator;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import net.sf.esfinge.metadata.validate.NeedToHaveAnnotationValidator;

@ToValidate(value = NeedToHaveAnnotationValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
public @interface NeedsToHave {
	public Class<? extends Annotation> value();
}
