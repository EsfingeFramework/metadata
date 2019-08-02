package net.sf.esfinge.container.processor.parameter;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

@Retention(RUNTIME)
@Target(ElementType.METHOD)

public @interface Annoted {

}
