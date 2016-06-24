package org.esfinge.metadata.container.reading;

import static org.apache.commons.beanutils.PropertyUtils.setProperty;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import org.esfinge.metadata.AnnotationReadingException;
import org.esfinge.metadata.container.AnnotationReadingProcessor;
import org.esfinge.metadata.container.ContainsAnnotation;

public class ContainsAnnotationReadingProcessor implements AnnotationReadingProcessor {
	
	private String containerAnnotatedField;
	private ContainsAnnotation  annot;

	@Override
	public void initAnnotation(Annotation an, Field field) {
		containerAnnotatedField = field.getName();
		annot =(ContainsAnnotation)an;		
	}

	@Override
	public void read(Class<?> classWithMetadata, Object container) throws AnnotationReadingException {
		try {
			
			Class<? extends Annotation> annotationThatNeedToContains = annot.value();
			setProperty(container, containerAnnotatedField, classWithMetadata.isAnnotationPresent(annotationThatNeedToContains));
			
		} catch (Exception e) {
			throw new AnnotationReadingException("Cannot read and record the element name",e);
		}
	}

}
