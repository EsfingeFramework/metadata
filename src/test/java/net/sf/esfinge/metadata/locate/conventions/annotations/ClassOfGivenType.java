package net.sf.esfinge.metadata.locate.conventions.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collection;

@Retention(RetentionPolicy.RUNTIME)
@ClassOfGivenTypeConvention(superClass= Collection.class,canBeSubtype = false)
public @interface ClassOfGivenType {
}
