package net.sf.esfinge.metadata.annotation.container;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import net.sf.esfinge.metadata.validate.needsToHave.SearchOnEnclosingElements;

@Retention(RetentionPolicy.RUNTIME)
@SearchOnEnclosingElements

public @interface ExecuteProcessor {
}
