package net.sf.esfinge.metadata.container;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;

import net.sf.esfinge.metadata.AnnotationReadingException;
import net.sf.esfinge.metadata.AnnotationValidationException;

public interface AnnotationReadingProcessor {
	
	void initAnnotation(Annotation an, Field field) throws AnnotationValidationException;
	
	void read(AnnotatedElement elementWithMetadata, Object container, ContainerTarget target) throws AnnotationReadingException;

}
