package org.esfinge.metadata;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.util.ArrayList;
import java.util.List;

import org.esfinge.metadata.locate.FatherLocator;
import org.esfinge.metadata.locate.MetadataLocator;
import org.esfinge.metadata.locate.RegularLocator;

public class AnnotationFinder {
	
	public static Annotation findAnnotation(AnnotatedElement element, Class<? extends Annotation> annotationClass){
		MetadataLocator locator = getAplicableLocatorChain(annotationClass);
		Annotation an = locator.findMetadata(element, annotationClass);
		return an;
	}
	
	private static MetadataLocator getAplicableLocatorChain(Class<? extends Annotation> annotationClass){
		MetadataLocator locator = new FatherLocator();
		locator.setNextLocator(new RegularLocator());
		return locator;
	}

}
