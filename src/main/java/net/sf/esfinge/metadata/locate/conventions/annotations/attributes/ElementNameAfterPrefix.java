package net.sf.esfinge.metadata.locate.conventions.annotations.attributes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@ValueGenerator(ElementNameAfterPrefixGenerator.class)
public @interface ElementNameAfterPrefix {

    String prefix();
    boolean firstLetterLowerCase() default true;
}
