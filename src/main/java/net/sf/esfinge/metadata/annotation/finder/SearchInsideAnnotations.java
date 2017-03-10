package net.sf.esfinge.metadata.annotation.finder;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import net.sf.esfinge.metadata.locate.AnnotationLocator;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
@Locator(value = AnnotationLocator.class, chainPriority = 10)
public @interface SearchInsideAnnotations {
}
