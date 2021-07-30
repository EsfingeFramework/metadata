package net.sf.esfinge.metadata.locate.conventions;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import net.sf.esfinge.metadata.locate.conventions.annotations.FieldTypeConvention;

@Retention(RetentionPolicy.RUNTIME)
@FieldTypeConvention(type=Number.class, canBeSubtype=true)
public @interface AsNumberInField {

}
