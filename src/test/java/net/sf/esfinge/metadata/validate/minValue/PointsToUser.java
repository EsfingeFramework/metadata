package net.sf.esfinge.metadata.validate.minValue;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import net.sf.esfinge.metadata.annotation.finder.SearchInsideAnnotations;
import net.sf.esfinge.metadata.annotation.finder.SearchOnEnclosingElements;
import net.sf.esfinge.metadata.annotation.validator.MaxValue;
import net.sf.esfinge.metadata.annotation.validator.MinValue;

@SearchOnEnclosingElements
@SearchInsideAnnotations
@Target({ElementType.METHOD,ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface PointsToUser {
	//verifica se a quantidade é maior ou menor que o minvalue
	@MinValue(value=0) 
	@MaxValue(value=10)
	int quantity();
	String name();
}