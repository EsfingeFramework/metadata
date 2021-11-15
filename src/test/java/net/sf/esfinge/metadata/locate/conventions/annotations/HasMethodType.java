package net.sf.esfinge.metadata.locate.conventions.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collection;

@Retention(RetentionPolicy.RUNTIME)
@MethodTypeConvention(parameters={Integer.class,Long.class, Collection.class},canBeSubtype = true)
public @interface HasMethodType {
}
