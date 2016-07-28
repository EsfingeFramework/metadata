package org.esfinge.metadata.container;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;

import org.esfinge.metadata.AnnotationReadingException;
import org.esfinge.metadata.AnnotationValidationException;

public interface AnnotationReadingProcessor {
	
	void initAnnotation(Annotation an, Field field) throws AnnotationValidationException;
	
	void read(AnnotatedElement classWithMetadata, Object container, ContainerTarget enumStr) throws AnnotationReadingException;

}
