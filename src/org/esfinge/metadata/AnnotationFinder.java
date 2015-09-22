package org.esfinge.metadata;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.util.ArrayList;
import java.util.List;

import org.esfinge.metadata.locate.AnnotationLocator;
import org.esfinge.metadata.locate.LevelLocator;
import org.esfinge.metadata.locate.MetadataLocator;
import org.esfinge.metadata.locate.RegularLocator;

public class AnnotationFinder {
	
	public static Annotation findAnnotation(AnnotatedElement element, Class<? extends Annotation> annotationClass){
		MetadataLocator locator = getAplicableLocatorChain();
		Annotation an = locator.findMetadata(element, annotationClass);
		return an;			
	}
	
	private static MetadataLocator getAplicableLocatorChain(){
		MetadataLocator locator = null;
		
		locator = new LevelLocator();
		locator.setNextLocator(new RegularLocator());		
		//locator.setNextLocator(new AnnotationLocator());				
		return locator;
	}

}
