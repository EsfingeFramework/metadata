package org.esfinge.metadata.container.reading;

import static org.apache.commons.beanutils.PropertyUtils.setProperty;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;

import org.esfinge.metadata.AnnotationReadingException;
import org.esfinge.metadata.container.AnnotationReadingProcessor;

public class ReflectionReferenceReadingProcessor implements AnnotationReadingProcessor {
	
	private String containerAnnotatedField;

	@Override
	public void initAnnotation(Annotation an, Field field) {
		containerAnnotatedField = field.getName();
	}

	@Override
	public void read(AnnotatedElement elementWithMetadata, Object container) throws AnnotationReadingException {
		try {
			setProperty(container, containerAnnotatedField,elementWithMetadata);
		
		} catch (Exception e) {
			throw new AnnotationReadingException("Cannot read and record the element name",e);
		}
	}

}
