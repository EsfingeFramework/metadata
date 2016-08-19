package net.sf.esfinge.metadata.annotation.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import net.sf.esfinge.metadata.validate.SiteValidoAnnotationValidator;

@ToValidateProperty(validationClass = SiteValidoAnnotationValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface SiteValido {	
}
