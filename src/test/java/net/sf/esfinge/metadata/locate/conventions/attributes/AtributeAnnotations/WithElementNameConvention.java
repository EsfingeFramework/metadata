package net.sf.esfinge.metadata.locate.conventions.attributes.AtributeAnnotations;

import net.sf.esfinge.metadata.locate.conventions.annotations.RegularExpressionConvention;
import net.sf.esfinge.metadata.locate.conventions.annotations.attributes.ElementName;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@RegularExpressionConvention(value = "insertPeople")
public @interface WithElementNameConvention {
    @ElementName(name = "insertPeople")
    String name();
}
