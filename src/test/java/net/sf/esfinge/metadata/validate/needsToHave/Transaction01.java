package net.sf.esfinge.metadata.validate.needsToHave;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import net.sf.esfinge.metadata.annotation.finder.SearchInsideAnnotations;
import net.sf.esfinge.metadata.annotation.finder.SearchOnEnclosingElements;
import net.sf.esfinge.metadata.annotation.validator.NeedsToHave;


@SearchInsideAnnotations
@SearchOnEnclosingElements
@Retention(RetentionPolicy.RUNTIME)
public @interface Transaction01 {

}