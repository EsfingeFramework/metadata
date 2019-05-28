package net.sf.esfinge.metadata.locate.convention;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import net.sf.esfinge.metadata.locate.convention.processor.ConventionNameContains;
import net.sf.esfinge.metadata.locate.convention.processor.ConventionNameEndsWith;
import net.sf.esfinge.metadata.locate.convention.processor.ConventionNameStartsWith;


@ConventionNameContains(contains="finding")
@ConventionNameEndsWith(posfix="find")
@ConventionNameStartsWith(prefix="find")
@Retention(RetentionPolicy.RUNTIME)
public @interface Finder {
}
