package net.sf.esfinge.metadata.locate.conventions.annotations.attributes;

import net.sf.esfinge.metadata.locate.conventions.annotations.attributes.generator.FixedStringGenerator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@ValueGenerator(FixedStringGenerator.class)
public @interface FixedStringValue {
    String value();
}
