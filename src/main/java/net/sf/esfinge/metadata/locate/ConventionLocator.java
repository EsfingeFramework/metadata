package net.sf.esfinge.metadata.locate;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;

public class ConventionLocator extends MetadataLocator {

	@Override
	public Annotation findMetadata(AnnotatedElement element,
			Class<? extends Annotation> annotationClass)
			throws MetadataLocationException {
		return null;
	}

	@Override
	public boolean hasMetadata(AnnotatedElement element,
			Class<? extends Annotation> annotationClass) {
		return false;
	}

}
