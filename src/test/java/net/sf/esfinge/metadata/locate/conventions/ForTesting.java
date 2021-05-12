package net.sf.esfinge.metadata.locate.conventions;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@PrefixConvention("prefix")
@SuffixConvention("suffix")
public @interface ForTesting {

}
