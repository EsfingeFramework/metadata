package net.sf.esfinge.metadata.locate.conventions.attributes.AtributeAnnotations;

import net.sf.esfinge.metadata.locate.conventions.annotations.PrefixConvention;
import net.sf.esfinge.metadata.locate.conventions.annotations.attributes.ElementNameAfterPrefix;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@PrefixConvention(value="insert")
public @interface WithAtributeConventions {
    @ElementNameAfterPrefix(prefix = "insert")
    String name();
}
