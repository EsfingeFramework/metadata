package net.sf.esfinge.metadata.locate.conventions;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import net.sf.esfinge.metadata.locate.conventions.annotations.PrefixConvention;
import net.sf.esfinge.metadata.locate.conventions.annotations.RegularExpressionConvention;
import net.sf.esfinge.metadata.locate.conventions.annotations.SuffixConvention;

@Retention(RetentionPolicy.RUNTIME)
@PrefixConvention("prefix")
@SuffixConvention("suffix")
@RegularExpressionConvention("regex") // good example (g|s)et* - anything started with get or set
public @interface ForTesting {

}

