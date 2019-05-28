package net.sf.esfinge.metadata.locate.convention;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import net.sf.esfinge.metadata.locate.convention.processor.ConventionNameContains;


@ConventionNameContains(contains="id")
@Retention(RetentionPolicy.RUNTIME)
public @interface ID {
}
