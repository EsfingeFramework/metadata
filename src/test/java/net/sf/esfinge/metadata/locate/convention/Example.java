package net.sf.esfinge.metadata.locate.convention;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import net.sf.esfinge.metadata.locate.convention.processor.ConventionNameEndsWith;


@ConventionNameEndsWith(posfix="example")
@Retention(RetentionPolicy.RUNTIME)
public @interface Example {
}
