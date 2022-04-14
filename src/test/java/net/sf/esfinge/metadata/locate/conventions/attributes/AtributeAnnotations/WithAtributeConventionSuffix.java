package net.sf.esfinge.metadata.locate.conventions.attributes.AtributeAnnotations;

import net.sf.esfinge.metadata.locate.conventions.annotations.SuffixConvention;
import net.sf.esfinge.metadata.locate.conventions.annotations.attributes.ElementNameBeforeSuffix;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@SuffixConvention(value = "People")
public @interface WithAtributeConventionSuffix {
    @ElementNameBeforeSuffix(suffix = "People")
    String name();
}
