package org.esfinge.metadata.validate.unique;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.esfinge.metadata.annotation.validator.SearchInsideAnnotations;
import org.esfinge.metadata.annotation.validator.SearchOnEnclosingElements;
import org.esfinge.metadata.annotation.validator.Unique;

@SearchOnEnclosingElements
@SearchInsideAnnotations
@Target({ElementType.METHOD,ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface PointsToUser {
	@Unique
	int quantity();
	@Unique
	String name();
}