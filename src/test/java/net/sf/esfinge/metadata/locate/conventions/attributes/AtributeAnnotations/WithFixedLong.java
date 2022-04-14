package net.sf.esfinge.metadata.locate.conventions.attributes.AtributeAnnotations;

import net.sf.esfinge.metadata.locate.conventions.annotations.MethodReturnTypeConvention;
import net.sf.esfinge.metadata.locate.conventions.annotations.attributes.FixedLongValue;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@MethodReturnTypeConvention(returnType = long.class)
public @interface WithFixedLong {
    @FixedLongValue(value = Long.MAX_VALUE)
    long value();
}
