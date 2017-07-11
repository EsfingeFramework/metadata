package net.sf.esfinge.metadata.locate.Heranca;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import net.sf.esfinge.metadata.annotation.finder.SearchInsideAnnotations;
import net.sf.esfinge.metadata.annotation.finder.SearchOnAbstractions;
import net.sf.esfinge.metadata.annotation.finder.SearchOnEnclosingElements;
@SearchOnAbstractions
@SearchOnEnclosingElements
@SearchInsideAnnotations
@Retention(RetentionPolicy.RUNTIME)
public @interface AnnotationReq {

}
