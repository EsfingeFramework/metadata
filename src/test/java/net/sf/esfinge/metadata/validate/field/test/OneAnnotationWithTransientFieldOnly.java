package net.sf.esfinge.metadata.validate.field.test;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import net.sf.esfinge.metadata.annotation.validator.SearchInsideAnnotations;
import net.sf.esfinge.metadata.annotation.validator.SearchOnEnclosingElements;
import net.sf.esfinge.metadata.annotation.validator.field.TransientFieldOnly;

@SearchInsideAnnotations
@SearchOnEnclosingElements
@TransientFieldOnly
@Retention(RetentionPolicy.RUNTIME)
public @interface OneAnnotationWithTransientFieldOnly {
}
