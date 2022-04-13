package net.sf.esfinge.metadata.locate.conventions.annotations.attributes;

import net.sf.esfinge.metadata.locate.conventions.annotations.attributes.generator.FixedIntegerGenerator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@ValueGenerator(FixedIntegerGenerator.class)
public @interface FixedIntegerValue {
    int value();
}
