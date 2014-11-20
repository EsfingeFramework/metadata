package org.esfinge.metadata.locate;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;

import org.esfinge.metadata.annotation.SearchAnnotationUntilLevel;

public class AnnotationLocator extends MetadataLocator {

	@Override
	public Annotation findMetadata(AnnotatedElement element, Class<? extends Annotation> annotationClass) {
		Annotation an = nextLocator.findMetadata(element, annotationClass);
		
		Annotation anot;
		
		if (annotationClass.isAnnotationPresent(SearchAnnotationUntilLevel.class)) {
			SearchAnnotationUntilLevel level = annotationClass.getAnnotation(SearchAnnotationUntilLevel.class);
			System.out.println("Propriedade nome = " + level.nivel());
		}
		//if(an == null){
			
		//}
		
		return an;
	}

	@Override
	public boolean hasMetadata(AnnotatedElement element, Class<? extends Annotation> annotationClass) {
		return false;
	}

}
