package net.sf.esfinge.metadata.TestAnnotationReader;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import net.sf.esfinge.metadata.annotation.validator.SearchInsideAnnotations;
import net.sf.esfinge.metadata.annotation.validator.SearchOnEnclosingElements;
@SearchOnEnclosingElements
@SearchInsideAnnotations
@Retention(RetentionPolicy.RUNTIME)
public @interface Tabela {
	String nome();
	
}
