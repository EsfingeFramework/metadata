package net.sf.esfinge.metadata.annotation.finder;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import net.sf.esfinge.metadata.locate.InsideAnnotationLocator;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
@Locator(value = InsideAnnotationLocator.class, chainPriority = 10)
public @interface SearchInsideAnnotations {
}
