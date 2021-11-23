package net.sf.esfinge.metadata.locate.conventions.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@MethodExactParamListConvention(parameters = {Integer.class,String.class})
public @interface MethodHasParamList {
}
