package net.sf.esfinge.metadata.container;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;

import net.sf.esfinge.metadata.AnnotationReadingException;
import net.sf.esfinge.metadata.AnnotationValidationException;
import net.sf.esfinge.metadata.annotation.container.ExecuteProcessor;

public interface AnnotationReadingProcessor {
	
	@ExecuteProcessor
	void initAnnotation(Annotation an, AnnotatedElement elementWithMetadata) throws AnnotationValidationException;
	
	void read(AnnotatedElement elementWithMetadata, Object container, ContainerTarget target) throws AnnotationReadingException;

}
