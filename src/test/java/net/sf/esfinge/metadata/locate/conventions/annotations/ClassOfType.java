package net.sf.esfinge.metadata.locate.conventions.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collection;

@Retention(RetentionPolicy.RUNTIME)
@ClassTypeConvention(superClass = Collection.class, canBeSubtype = true)
public @interface ClassOfType {
}
