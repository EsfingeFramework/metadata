package net.sf.esfinge.metadata.annotation.finder;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import net.sf.esfinge.metadata.locate.MetadataLocator;

@Retention(RUNTIME)
@Target(ANNOTATION_TYPE)
public @interface Locator {
	public Class<? extends MetadataLocator> value();
	public int chainPriority();
}
