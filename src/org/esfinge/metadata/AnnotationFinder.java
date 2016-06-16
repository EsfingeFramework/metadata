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
	
	public static List<Annotation> findAnnotation(AnnotatedElement element, Class<? extends Annotation> annotationClass){
		//LocatorsFactory factory = new LocatorsFactory();
		//MetadataLocator locatorsChain = factory.createLocatorsChain(element);
		//Annotation an = locatorsChain.findMetadata(element, annotationClass);
		List<MetadataLocator> locators = getAplicableLocatorChain();
		List<Annotation> annotations = new ArrayList<Annotation>();
		
		for(MetadataLocator locator: locators){
			Annotation an = locator.findMetadata(element, annotationClass);
			if(an != null) {
				annotations.add(an);
			}
		}
		return annotations;			
	}
	
	private static List<MetadataLocator> getAplicableLocatorChain(){
		List<MetadataLocator> list = new ArrayList<>();
		list.add(new LevelLocator());
		list.add(new AnnotationLocator());
		list.add(new RegularLocator());
		
		return list;
	}
}
