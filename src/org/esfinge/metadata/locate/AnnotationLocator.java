package org.esfinge.metadata.locate;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.esfinge.metadata.annotation.SearchOnEnclosingElements;

public class AnnotationLocator extends MetadataLocator {

	@Override
	// AnnotatedElement element -> (class, method, annotation, attribute...)
	// Class<? extends Annotation> annotationClass -> (annotation)
	public Annotation findMetadata(AnnotatedElement element, Class<? extends Annotation> annotationClass) {

		Annotation an = null;

		Annotation[] ans = element.getAnnotations();		
		
		for (Annotation a : ans) {		
			Class<?> c = a.annotationType();
			if (searchOnEnclosingElements(c)) 				
				an = nextLocator.findMetadata(c, annotationClass);						
		}		
		return an;
	}

	// if true, Button-up searching
	public static boolean searchOnEnclosingElements(Class<?> c) {
		return c.isAnnotationPresent(SearchOnEnclosingElements.class);
	}

	@Override
	public boolean hasMetadata(AnnotatedElement element, Class<? extends Annotation> annotationClass) {
		return false;
	}
}
