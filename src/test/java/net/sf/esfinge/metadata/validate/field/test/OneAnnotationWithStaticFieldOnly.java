package net.sf.esfinge.metadata.validate.field.test;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import net.sf.esfinge.metadata.annotation.finder.SearchInsideAnnotations;
import net.sf.esfinge.metadata.annotation.finder.SearchOnEnclosingElements;
import net.sf.esfinge.metadata.annotation.validator.field.StaticFieldOnly;

@SearchInsideAnnotations
@SearchOnEnclosingElements
@StaticFieldOnly
@Retention(RetentionPolicy.RUNTIME)
public @interface OneAnnotationWithStaticFieldOnly {
}
