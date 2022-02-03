package net.sf.esfinge.metadata.locate;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.util.List;

public abstract class MetadataLocator {

	protected MetadataLocator nextLocator;

	public void setNextLocator(MetadataLocator locator) {
		MetadataLocator currentLocator = this;
		while(currentLocator.getNextLocator() != null) {
			currentLocator = currentLocator.getNextLocator();
		}
		currentLocator.nextLocator = locator;
	}
	public abstract List<Annotation> findAllMetadata(AnnotatedElement element) throws MetadataLocationException;


	public MetadataLocator getNextLocator() {
		return nextLocator;
	}

	public abstract Annotation findMetadata(AnnotatedElement element, Class<? extends Annotation> annotationClass)
			throws MetadataLocationException;

	public abstract boolean hasMetadata(AnnotatedElement element, Class<? extends Annotation> annotationClass)
			throws MetadataLocationException;

}
