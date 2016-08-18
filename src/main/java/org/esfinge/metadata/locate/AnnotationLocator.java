package org.esfinge.metadata.locate;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;

import org.esfinge.metadata.annotation.validator.SearchInsideAnnotations;

public class AnnotationLocator extends MetadataLocator {
	private int contador = 0;
	private AnnotatedElement OriginalElement;

	@Override
	public Annotation findMetadata(AnnotatedElement element,
			Class<? extends Annotation> annotationClass) {
		if (contador == 0)
			OriginalElement = element;

		contador++;		
		
		Annotation an=null;	
		
		Annotation[] ans = element.getAnnotations();		
		
		for (Annotation a : ans) {			
			Class<?>c = a.annotationType();							
			// exclui anotacoes predefinidas do Java e do Esfinge Metadata
			if (!isJavaAnnotation(c) &&	!isEsfingeMetadataAnnotation(c) &&			
				 searchInsideAnnotation(annotationClass) && searchInsideAnnotation(c)) {					
				if (c.equals(annotationClass)) {											
					an = a;
					return an;
				}else {
					return findMetadata(c, annotationClass);
				}							
			}
		}		
		return an;	
	}

	private boolean isEsfingeMetadataAnnotation(Class<?> c) {
		return c.getPackage().getName().equals("org.esfinge.metadata.annotation.validator");
	}

	private boolean isJavaAnnotation(Class<?> c) {
		return c.getPackage().getName().equals("java.lang.annotation");
	}

	// if true, searches inside other annotation
	private boolean searchInsideAnnotation(Class<?> c) {
		return c.isAnnotationPresent(SearchInsideAnnotations.class);
	}

	@Override
	public boolean hasMetadata(AnnotatedElement element,
			Class<? extends Annotation> annotationClass) {
		return false;
	}
}
