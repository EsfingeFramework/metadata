package net.sf.esfinge.metadata.annotation.finder;

import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import net.sf.esfinge.metadata.locate.EnclosingElementLocator;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
@Locator(value = EnclosingElementLocator.class, chainPriority=20)
public @interface SearchOnEnclosingElements {
}
