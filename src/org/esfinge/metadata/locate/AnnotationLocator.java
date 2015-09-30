package org.esfinge.metadata.locate;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;

import org.esfinge.metadata.validate.needsToHave.SearchInsideAnnotations;

public class AnnotationLocator extends MetadataLocator {

	@Override
	// AnnotatedElement element -> (class, method, annotation, attribute...)
	// Class<? extends Annotation> annotationClass -> (annotation)
	public Annotation findMetadata(AnnotatedElement element, Class<? extends Annotation> annotationClass) {

		Annotation an = null;

		Annotation[] ans = element.getAnnotations();		
		
		for (Annotation a : ans) {		
			Class<?> c = a.annotationType();
			if (searchInsideAnnotation(c)) 				
				an = nextLocator.findMetadata(c, annotationClass);						
		}		
		return an;
	}

	// if true, searches inside other annotation
	public static boolean searchInsideAnnotation(Class<?> c) {
		return c.isAnnotationPresent(SearchInsideAnnotations.class);
	}

	@Override
	public boolean hasMetadata(AnnotatedElement element, Class<? extends Annotation> annotationClass) {
		return false;
	}
}
