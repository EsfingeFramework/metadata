package net.sf.esfinge.metadata.locate.conventions.attributes.AtributeAnnotations;

import net.sf.esfinge.metadata.locate.conventions.annotations.MethodExactParamListConvention;
import net.sf.esfinge.metadata.locate.conventions.annotations.MethodReturnTypeConvention;
import net.sf.esfinge.metadata.locate.conventions.annotations.attributes.FixedIntegerValue;
import net.sf.esfinge.metadata.locate.conventions.annotations.attributes.FixedStringValue;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@MethodExactParamListConvention(parameters = {String.class,int.class})
public @interface WithTwoAtributes {
    @FixedStringValue(value = "Joao")
    String name();
    @FixedIntegerValue(value = 22)
    int age();
}
