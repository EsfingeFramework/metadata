package org.esfinge.metadata.locate;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;

public class RegularLocator extends MetadataLocator {
	
	@Override
	public void setNextLocator(MetadataLocator locator) {
		throw new UnsupportedOperationException(
				"This is a final locator and should not receive another one");
	}

	@Override
	public Annotation findMetadata(AnnotatedElement element,
			Class<? extends Annotation> annotationClass)
			throws MetadataLocationException {
		return element.getAnnotation(annotationClass);
	}

	@Override
	public boolean hasMetadata(AnnotatedElement element, Class<? extends Annotation> annotationClass) {
		Annotation a = null;
		Object o = null;
		Class<? extends Annotation> c = annotationClass;
		a = c.getAnnotation(annotationClass);
		
		if (a != null) {
			Method [] m = c.getDeclaredMethods();
			if(m.length > 0) return true;
		}
		return false;
	}
}
