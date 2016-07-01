package org.esfinge.metadata;

import java.lang.annotation.Annotation;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;

import org.esfinge.metadata.container.AnnotationReadingConfig;
import org.esfinge.metadata.container.AnnotationReadingProcessor;

public class AnnotationReader {

	// To be modified as necessary. Currently only checks if BooleanAnnotation
	// is present on methods.
	// TODO:Checking on classes and parameters

	public <E> E readingAnnotationsTo(AnnotatedElement elementWithMetadata, Class<E> containerClass) throws Exception {

		Object container = containerClass.newInstance();

		for (Field field : containerClass.getDeclaredFields()) {			
			for (Annotation an : field.getAnnotations()) {
				Class<?> annotationClass = an.annotationType();
				if (AnnotationFinder.existAnnotation(annotationClass, AnnotationReadingConfig.class))
				//if (annotationClass.isAnnotationPresent(AnnotationReadingConfig.class)) 
				{
					AnnotationReadingConfig arc = annotationClass.getAnnotation(AnnotationReadingConfig.class);
					AnnotationReadingProcessor processor = arc.value().newInstance();
					processor.initAnnotation(an, field);
					processor.read(elementWithMetadata, container);
				}
			}
		}

		return (E) container;
	}

}
