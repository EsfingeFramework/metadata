package net.sf.esfinge.metadata.locate.locators;

import net.sf.esfinge.metadata.annotation.finder.SearchInsideAnnotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@SearchInsideAnnotations
@Retention(RetentionPolicy.RUNTIME)
public @interface ToTestInside {
}
