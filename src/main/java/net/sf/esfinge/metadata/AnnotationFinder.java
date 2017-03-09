package net.sf.esfinge.metadata;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.util.ArrayList;
import java.util.List;

import net.sf.esfinge.metadata.locate.AnnotationLocator;
import net.sf.esfinge.metadata.locate.InheritanceLocator;
import net.sf.esfinge.metadata.locate.LevelLocator;
import net.sf.esfinge.metadata.locate.MetadataLocator;
import net.sf.esfinge.metadata.locate.RegularLocator;

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
	
	public static boolean existAnnotation(AnnotatedElement element, Class<? extends Annotation> annotationClass){
		return !findAnnotation(element, annotationClass).isEmpty();		
	}
	
	
	private static List<MetadataLocator> getAplicableLocatorChain(){
		List<MetadataLocator> list = new ArrayList<>();
		list.add(new InheritanceLocator());
		list.add(new LevelLocator());
		list.add(new AnnotationLocator());
		list.add(new RegularLocator());
		
		

		
		return list;
	}
}
