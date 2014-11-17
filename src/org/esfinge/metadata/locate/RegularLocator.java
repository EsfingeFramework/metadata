package org.esfinge.metadata.locate;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;

public class RegularLocator extends MetadataLocator {
	
	@Override
	public void setNextLocator(MetadataLocator locator) {
		throw new UnsupportedOperationException("This is a final locator and should not receive another one");
	}

	@Override
	public Annotation findMetadata(AnnotatedElement element, Class<? extends Annotation> annotationClass) {
		return element.getAnnotation(annotationClass);
	}

	@Override
	public boolean hasMetadata(AnnotatedElement element, Class<? extends Annotation> annotationClass) {
		return false;
	}

}
