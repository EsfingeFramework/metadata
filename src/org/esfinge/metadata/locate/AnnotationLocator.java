package org.esfinge.metadata.locate;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;

import org.esfinge.metadata.validate.needsToHave.SearchInsideAnnotations;

public class AnnotationLocator extends MetadataLocator {
	private int contador = 0;
	private AnnotatedElement OrginalElement;

	@Override
	// AnnotatedElement element -> (class, method, annotation, attribute...)
	// Class<? extends Annotation> annotationClass -> (annotation)
	public Annotation findMetadata(AnnotatedElement element,
			Class<? extends Annotation> annotationClass) {

		if (contador == 0)
			OrginalElement = element;

		contador++;

		Annotation an = null;

		Annotation[] ans = element.getAnnotations();
		for (Annotation a : ans) {
			// exclui anotações predefinidas do Java
			if (!a.annotationType().getPackage().getName().equals("java.lang.annotation")) {

				Class<?> c = a.annotationType();
				// System.out.println(contador + " " + c.toString());

				if (c.equals(annotationClass)) {
					if (searchInsideAnnotation(annotationClass)
							&& searchInsideAnnotation(c)) {
						return an = a;
					}
				} else {
					return findMetadata(c, annotationClass);
				}
			}
		}

		if (an == null)
			an = nextLocator.findMetadata(OrginalElement, annotationClass);
		return an;
	}

	// if true, searches inside other annotation
	public static boolean searchInsideAnnotation(Class<?> c) {
		return c.isAnnotationPresent(SearchInsideAnnotations.class);
	}

	@Override
	public boolean hasMetadata(AnnotatedElement element,
			Class<? extends Annotation> annotationClass) {
		return false;
	}
}
