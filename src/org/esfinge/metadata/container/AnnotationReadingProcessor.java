package org.esfinge.metadata.container;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import org.esfinge.metadata.AnnotationReadingException;

public interface AnnotationReadingProcessor {
	
	void initAnnotation(Annotation an, Field field);
	
	void read(Class<?> classWithMetadata, Object container) throws AnnotationReadingException;

}
