package org.esfinge.metadata;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class FatherLocator implements MetadataLocator {

	@Override
	public Annotation findMetadata(AnnotatedElement element, Class<? extends Annotation> annotationClass)
			throws MetadataLocationException {
		Annotation an = element.getAnnotation(annotationClass);

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
		
		//Top-down Searching
		else{
			
		}
		
		return an;
	}

	//if true, Button-up searching
	public static boolean searchOnEnclosingTypes(Class<? extends Annotation> c, AnnotatedElement ae) {
		if (ae.isAnnotationPresent(SearchOnEnclosingTypes.class)) 
			return true;
		
		return false;
	}

	@Override
	public boolean hasMetadata(AnnotatedElement element,
			Class<? extends Annotation> annotationClass) {
		return false;
	}

}
