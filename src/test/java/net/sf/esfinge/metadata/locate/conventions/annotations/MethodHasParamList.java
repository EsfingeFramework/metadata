package net.sf.esfinge.metadata.locate.conventions.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@MethodExactParamListConvention(parameters = {Integer.class})
public @interface MethodHasParamList {
}
