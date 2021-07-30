package net.sf.esfinge.metadata.locate.conventions;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import net.sf.esfinge.metadata.locate.conventions.annotations.AllConventionsNeedToApply;
import net.sf.esfinge.metadata.locate.conventions.annotations.FieldTypeConvention;
import net.sf.esfinge.metadata.locate.conventions.annotations.PrefixConvention;

@Retention(RetentionPolicy.RUNTIME)
@FieldTypeConvention(type=Number.class)
@PrefixConvention("int")
@AllConventionsNeedToApply
public @interface WithTwoConventions {
}
