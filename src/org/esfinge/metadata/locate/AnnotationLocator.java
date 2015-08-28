package org.esfinge.metadata.locate;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class AnnotationLocator extends MetadataLocator {
	/*
	 * public static void main(String args[]){ AnnotationLocator locator = new
	 * AnnotationLocator();
	 * 
	 * Annotation an = locator.findMetadata(ForTest.class,FindMeClass.class);
	 * 
	 * System.out.println("retorno:"+an.annotationType().getSimpleName());
	 * 
	 * }
	 */

	@Override
	// AnnotatedElement element -> (class, method, annotation, attribute...)
	// Class<? extends Annotation> annotationClass -> (annotation)
	public Annotation findMetadata(AnnotatedElement element, Class<? extends Annotation> annotationClass) {
		
		Annotation an = nextLocator.findMetadata(element, annotationClass);
		//Annotation an =null;

		if (an == null) {
			Annotation[] ans = element.getAnnotations();
			// Button-up Searching
			if (ans.length <= 0) {
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
			} else {
				for (Annotation a : ans) {
					if (a.annotationType().getSimpleName()
							.equals(annotationClass.getSimpleName()))
						return a;
					return findMetadata(a.annotationType(), annotationClass);
				}
			}
		}
		return an;
	}

	@Override
	public boolean hasMetadata(AnnotatedElement element,
			Class<? extends Annotation> annotationClass) {
		return false;
	}

}
