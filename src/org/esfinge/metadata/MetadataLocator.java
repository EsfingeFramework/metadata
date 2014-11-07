package org.esfinge.metadata;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;

public interface MetadataLocator {
	
	public Annotation findMetadata(AnnotatedElement element, 
			Class<? extends Annotation> annotationClass) throws MetadataLocationException;
	
	public boolean hasMetadata(AnnotatedElement element, 
			Class<? extends Annotation> annotationClass);

}
