package net.sf.esfinge.metadata;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.util.ArrayList;
import java.util.List;

import net.sf.esfinge.metadata.locate.InsideAnnotationLocator;
import net.sf.esfinge.metadata.locate.InheritanceLocator;
import net.sf.esfinge.metadata.locate.EnclosingElementLocator;
import net.sf.esfinge.metadata.locate.MetadataLocator;
import net.sf.esfinge.metadata.locate.RegularLocator;

public class AnnotationFinderOld {
	//TODO Refatorar
	public static List<Annotation> findAnnotation(AnnotatedElement element, Class<? extends Annotation> annotationClass){

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
		list.add(new EnclosingElementLocator());
		list.add(new InsideAnnotationLocator());
		list.add(new RegularLocator());

		return list;
	}
}
