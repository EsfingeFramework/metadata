package net.sf.esfinge.metadata;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.sf.esfinge.metadata.annotation.finder.Locator;
import net.sf.esfinge.metadata.locate.AnnotationLocator;
import net.sf.esfinge.metadata.locate.InheritanceLocator;
import net.sf.esfinge.metadata.locate.EnclosingElementLocator;
import net.sf.esfinge.metadata.locate.MetadataLocator;
import net.sf.esfinge.metadata.locate.RegularLocator;

public class AnnotationFinder {
	
	public static List<Annotation> findAnnotation(AnnotatedElement element, Class<? extends Annotation> annotationClass){

		Map<Integer, MetadataLocator> locators = getAplicableLocatorChain(annotationClass);
		List<Annotation> annotations = new ArrayList<Annotation>();
		for (Map.Entry<Integer, MetadataLocator> entry : locators.entrySet()) {
			Annotation an = entry.getValue().findMetadata(element, annotationClass);
			if(an != null) {
				annotations.add(an);
			}
		}
		return annotations;			
	}
	
	public static boolean existAnnotation(AnnotatedElement element, Class<? extends Annotation> annotationClass){
		return !findAnnotation(element, annotationClass).isEmpty();		
	}
	
	
	private static Map<Integer, MetadataLocator> getAplicableLocatorChain(Class<? extends Annotation> annotationClass){
		Map<Integer, MetadataLocator> locators = new LinkedHashMap<Integer, MetadataLocator>();
			for(Annotation annotation:annotationClass.getAnnotations()){
				if(annotation.annotationType().isAnnotationPresent(Locator.class))				{
					Locator chain = annotation.annotationType().getAnnotation(Locator.class);
					try {
						locators.put(chain.chainPriority(), chain.value().newInstance());
					} catch (InstantiationException | IllegalAccessException e) {
						e.printStackTrace();
					}
				}
			}
		locators.put(0, new RegularLocator());
		return locators;
	}
}
