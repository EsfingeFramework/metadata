package net.sf.esfinge.metadata.container.reading;

import static org.apache.commons.beanutils.PropertyUtils.setProperty;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;

import net.sf.esfinge.metadata.AnnotationFinder;
import net.sf.esfinge.metadata.AnnotationReadingException;
import net.sf.esfinge.metadata.annotation.container.ContainsAnnotation;
import net.sf.esfinge.metadata.container.AnnotationReadingProcessor;
import net.sf.esfinge.metadata.container.ContainerTarget;

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
			//throw new AnnotationReadingException("Cannot read and record the container ContainsAnnotation",e);
			throw new AnnotationReadingException("Cannot read and record the container = "+containerAnnotatedField+"annotation = "+annot.value(),e);
		}
	}

}
