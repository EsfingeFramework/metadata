package net.sf.esfinge.metadata.locate.conventions.attributes.AtributeAnnotations;


import net.sf.esfinge.metadata.locate.conventions.annotations.MethodReturnTypeConvention;
import net.sf.esfinge.metadata.locate.conventions.annotations.PrefixConvention;
import net.sf.esfinge.metadata.locate.conventions.annotations.attributes.FixedStringValue;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@MethodReturnTypeConvention(returnType = String.class)
public @interface WithFixedString {
    @FixedStringValue(value = "insert")
    String value();
}
