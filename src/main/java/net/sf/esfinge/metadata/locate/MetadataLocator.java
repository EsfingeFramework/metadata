package net.sf.esfinge.metadata.locate;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;

public abstract class MetadataLocator {

	protected MetadataLocator nextLocator;

	public void setNextLocator(MetadataLocator locator) {
		MetadataLocator currentLocator = this;
		while(currentLocator.getNextLocator() != null) {
			currentLocator = currentLocator.getNextLocator();
		}
		currentLocator.nextLocator = locator;
	}
	
	public MetadataLocator getNextLocator() {
		return nextLocator;
	}

	public abstract Annotation findMetadata(AnnotatedElement element, Class<? extends Annotation> annotationClass)
			throws MetadataLocationException;

	public abstract boolean hasMetadata(AnnotatedElement element, Class<? extends Annotation> annotationClass);

}
