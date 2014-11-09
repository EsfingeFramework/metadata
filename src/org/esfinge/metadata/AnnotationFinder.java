package org.esfinge.metadata;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.util.ArrayList;
import java.util.List;

public class AnnotationFinder {
	
	public static Annotation findAnnotation(AnnotatedElement element, Class<? extends Annotation> annotationClass){
		List<MetadataLocator> locators = getAplicableLocators(annotationClass);
		
		for(MetadataLocator locator : locators){
			Annotation an = locator.findMetadata(element, annotationClass);
			if(an != null)
				return an;
		}
		
		return null;
	}
	
	private static List<MetadataLocator> getAplicableLocators(Class<? extends Annotation> annotationClass){
		List<MetadataLocator> list = new ArrayList<>();
		list.add(new RegularLocator());
		list.add(new FatherLocator());
		//list.add(new ConventionLocator());
		return list;
	}

}
