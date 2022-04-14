package net.sf.esfinge.metadata.locate.conventions.attributes.AtributeAnnotations;

import net.sf.esfinge.metadata.locate.conventions.annotations.MethodReturnTypeConvention;
import net.sf.esfinge.metadata.locate.conventions.annotations.attributes.FixedDoubleValue;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@MethodReturnTypeConvention(returnType = double.class)
public @interface WithFixedDouble {
    @FixedDoubleValue(value = Double.MAX_VALUE)
    double value();
}
