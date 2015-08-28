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
	
	/*//Without chain of responsability
	public static Annotation findAnnotation(AnnotatedElement element, Class<? extends Annotation> annotationClass){
		
		List<MetadataLocator> locators = getAplicableLocatorChain();

		for(MetadataLocator locator: locators){
			Annotation an = locator.findMetadata(element, annotationClass);
			if(an != null) return an;
		}
		return null;			
	}
	
	private static List<MetadataLocator> getAplicableLocatorChain(){
		List<MetadataLocator> list = new ArrayList<>();
	    list.add(new RegularLocator());
		list.add(new LevelLocator());
		//list.add(new AnnotationLocator());		
		return list;
	}
	
*/
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
