package org.esfinge.metadata.locate;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;

public abstract class MetadataLocator {

	protected MetadataLocator nextLocator;

	public void setNextLocator(MetadataLocator locator) {
		this.nextLocator = locator;
	}

	public abstract Annotation findMetadata(AnnotatedElement element, Class<? extends Annotation> annotationClass)
			throws MetadataLocationException;

	public abstract boolean hasMetadata(AnnotatedElement element, Class<? extends Annotation> annotationClass);

}
