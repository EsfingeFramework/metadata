package net.sf.esfinge.metadata.locate.conventions;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@PrefixConvention("prefix")
public @interface ForTesting {

}
