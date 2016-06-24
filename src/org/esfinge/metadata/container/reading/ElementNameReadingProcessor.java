package org.esfinge.metadata.container.reading;

import static org.apache.commons.beanutils.PropertyUtils.setProperty;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import org.esfinge.metadata.AnnotationReadingException;
import org.esfinge.metadata.container.AnnotationReadingProcessor;

public class ElementNameReadingProcessor implements AnnotationReadingProcessor {
	
	private String containerAnnotatedField;

	@Override
	public void initAnnotation(Annotation an, Field field) {
		containerAnnotatedField = field.getName();
	}

	@Override
	public void read(Class<?> classWithMetadata, Object container) throws AnnotationReadingException {
		try {
			setProperty(container,containerAnnotatedField,classWithMetadata.getName());
		} catch (Exception e) {
			throw new AnnotationReadingException("Cannot read and record the element name",e);
		}
	}

}
