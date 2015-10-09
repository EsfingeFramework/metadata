package org.esfinge.metadata;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import org.esfinge.metadata.factory.LocatorsFactory;
import org.esfinge.metadata.locate.MetadataLocator;

public class AnnotationFinder {
	
	public static Annotation findAnnotation(AnnotatedElement element, Class<? extends Annotation> annotationClass){
		LocatorsFactory factory = new LocatorsFactory();
		Annotation an;
		MetadataLocator locatorsChain;
		
		locatorsChain = factory.createLocatorsChain(element, annotationClass);
		an = locatorsChain.findMetadata(element, annotationClass);				
		return an;			
	}
}
