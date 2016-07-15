package org.esfinge.metadata.container.reading;

import static org.apache.commons.beanutils.PropertyUtils.setProperty;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;

import org.esfinge.metadata.AnnotationFinder;
import org.esfinge.metadata.AnnotationReadingException;
import org.esfinge.metadata.annotation.container.ContainsAnnotation;
import org.esfinge.metadata.container.AnnotationReadingProcessor;
import org.esfinge.metadata.container.ContainerTarget;

public class ContainsAnnotationReadingProcessor implements AnnotationReadingProcessor {
	
	private String containerAnnotatedField;
	private ContainsAnnotation  annot;

	@Override
	public void initAnnotation(Annotation an, Field field) {
		containerAnnotatedField = field.getName();
		annot =(ContainsAnnotation)an;		
	}

	@Override
	public void read(AnnotatedElement elementWithMetadata, Object container,ContainerTarget enumStr) throws AnnotationReadingException {
		try {
			
			Class<? extends Annotation> annotationThatNeedToContains = annot.value();
			setProperty(container, containerAnnotatedField,	AnnotationFinder.existAnnotation(elementWithMetadata,annotationThatNeedToContains));
			
		} catch (Exception e) {
			throw new AnnotationReadingException("Cannot read and record the container annotated field",e);
		}
	}

}
