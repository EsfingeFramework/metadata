package net.sf.esfinge.metadata.locate;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class RegularLocator extends MetadataLocator {
	
	@Override
	public void setNextLocator(MetadataLocator locator) {
		throw new UnsupportedOperationException(
				"RegularLocator should be the final locator and should not receive another one");
	}

	@Override
	public Annotation findMetadata(AnnotatedElement element,
			Class<? extends Annotation> annotationClass)
			throws MetadataLocationException {

		return element.getAnnotation(annotationClass);
	}
	@Override
	public List<Annotation> findAllMetadata(AnnotatedElement element) throws MetadataLocationException {
		return Arrays.asList(element.getAnnotations());
	}
	@Override
	public boolean hasMetadata(AnnotatedElement element, Class<? extends Annotation> annotationClass) {

		return element.isAnnotationPresent(annotationClass);
	}

}
