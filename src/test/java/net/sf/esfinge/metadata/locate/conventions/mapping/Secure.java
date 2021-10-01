package net.sf.esfinge.metadata.locate.conventions.mapping;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import net.sf.esfinge.metadata.locate.conventions.annotations.SuffixConvention;

@Retention(RetentionPolicy.RUNTIME)
@SuffixConvention("locked")
public @interface Secure {
}
