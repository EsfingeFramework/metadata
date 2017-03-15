package net.sf.esfinge.metadata.annotation.finder;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import net.sf.esfinge.metadata.locate.InsideAnnotationLocator;
import net.sf.esfinge.metadata.locate.InheritanceLocator;

@Retention(RUNTIME)
@Target(ANNOTATION_TYPE)
@Locator(value = InheritanceLocator.class, chainPriority=30)
public @interface SearchOnAbstractions {

}
