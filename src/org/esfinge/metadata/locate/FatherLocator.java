package org.esfinge.metadata.locate;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.esfinge.metadata.annotation.SearchOnEnclosingElements;

public class FatherLocator extends MetadataLocator {

	@Override
	public Annotation findMetadata(AnnotatedElement element, Class<? extends Annotation> annotationClass)
			throws MetadataLocationException {
		
		Annotation an = nextLocator.findMetadata(element, annotationClass);

		//Button-up Searching 
		if (an == null && !searchOnEnclosingTypes(annotationClass, element)) {
			if (element instanceof Method) {
				return findMetadata(((Method) element).getDeclaringClass(),
						annotationClass);
			} else if (element instanceof Field) {
				return findMetadata(((Field) element).getDeclaringClass(),
						annotationClass);
			} else if (element instanceof Class) {
				return findMetadata(((Class) element).getPackage(),
						annotationClass);
			}
		}
		
		return an;
	}

	//if true, Button-up searching
	public static boolean searchOnEnclosingTypes(Class<? extends Annotation> c, AnnotatedElement ae) {
		if (ae.isAnnotationPresent(SearchOnEnclosingElements.class)) 
			return true;
		return false;
	}

	@Override
	public boolean hasMetadata(AnnotatedElement element,
			Class<? extends Annotation> annotationClass) {
		return false;
	}

}
