package net.sf.esfinge.metadata.locate.levelLocator;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import net.sf.esfinge.metadata.annotation.finder.SearchOnEnclosingElements;

@SearchOnEnclosingElements
@Retention(RetentionPolicy.RUNTIME)
public @interface TransactionSearchOnEnclosing {

}
