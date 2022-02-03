package net.sf.esfinge.metadata.locate;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Member;
import java.util.List;

import net.sf.esfinge.metadata.AnnotationFinder;
import net.sf.esfinge.metadata.annotation.finder.SearchInsideAnnotations;
import net.sf.esfinge.metadata.annotation.finder.SearchOnEnclosingElements;

public class InsideAnnotationLocator extends MetadataLocator {


	@Override
	public List<Annotation> findAllMetadata(AnnotatedElement element) throws MetadataLocationException {
		return null;
	}

	@Override
	public Annotation findMetadata(AnnotatedElement element, Class<? extends Annotation> annotationClass) {
		Annotation nextLocatorFound  = getNextLocator().findMetadata(element, annotationClass);
		if(nextLocatorFound==null && annotationClass.isAnnotationPresent(SearchInsideAnnotations.class)){
			Annotation annotation = null;
			for(Annotation a : element.getAnnotations()) {
				if(!a.annotationType().getPackage().getName().equals("java.lang.annotation"))
					annotation =  findMetadata(a.annotationType(),annotationClass);
			}
			return annotation;
		}
		return nextLocatorFound;
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
