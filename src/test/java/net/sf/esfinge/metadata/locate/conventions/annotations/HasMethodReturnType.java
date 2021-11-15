package net.sf.esfinge.metadata.locate.conventions.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collection;

@MethodReturnTypeConvention(returnType = Collection.class,canBeSubtype = true)
@Retention(RetentionPolicy.RUNTIME)
public @interface HasMethodReturnType {
}
