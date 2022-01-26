package net.sf.esfinge.metadata.locate;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Member;
import java.util.List;

import net.sf.esfinge.metadata.AnnotationFinder;
import net.sf.esfinge.metadata.annotation.finder.SearchInsideAnnotations;
import net.sf.esfinge.metadata.annotation.finder.SearchOnEnclosingElements;

public class InsideAnnotationLocator extends MetadataLocator {
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
			if (!isJavaAnnotation(c) &&	!isEsfingeMetadataAnnotation(c)) {					
				if (c.equals(annotationClass)) {

					an = a;
					return an;
				}else {
					boolean exist = AnnotationFinder.existAnnotation(c, annotationClass);
					List<Annotation> value = AnnotationFinder.findAnnotation(c, annotationClass);
					if(exist == true)
					{
						an = value.get(0);
					}
										
				}							
			}
		}

		return an;	
	}

	private boolean isEsfingeMetadataAnnotation(Class<?> c) {
		return c.getPackage().getName().equals("net.sf.esfinge.metadata.annotation.validator");
	}

	private boolean isJavaAnnotation(Class<?> c) {
		return c.getPackage().getName().equals("java.lang.annotation");
	}

	// if true, searches inside other annotation
	private boolean searchInsideAnnotation(Class<?> c) {
		
		return AnnotationFinder.existAnnotation(c, SearchInsideAnnotations.class);
	}

	@Override
	public boolean hasMetadata(AnnotatedElement element, Class<? extends Annotation> annotationClass) {

		boolean nextLocatorFound  = getNextLocator().hasMetadata(element, annotationClass);
		if(!nextLocatorFound && annotationClass.isAnnotationPresent(SearchInsideAnnotations.class)) {
			boolean result = false;

			for(Annotation a : element.getAnnotations()) {

				if(!a.annotationType().getPackage().getName().equals("java.lang.annotation"))
					result = result && hasMetadata(a.annotationType(),annotationClass);
			}
			return result;
		}

		return nextLocatorFound;

	}
}
