package net.sf.esfinge.metadata.container.reading;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.apache.commons.beanutils.PropertyUtils;

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
				boolean value = AnnotationFinder.existAnnotation(elementWithMetadata,annotationThatNeedToContains);				PropertyUtils.setProperty(container, containerAnnotatedField, value);			
			
		} catch (Exception e) {
			//throw new AnnotationReadingException("Cannot read and record the container ContainsAnnotation",e);
			throw new AnnotationReadingException("Cannot read and record the container = "+containerAnnotatedField+"annotation = "+annot.value(),e);
		}
	}
	
    public static String propertyToGetter(String propertieName) {
		return propertyToGetter(propertieName, false);
	}
    
    public static String propertyToGetter(String propertieName, boolean isBoolean) {
		if(isBoolean)
			return "is"+propertieName.substring(0,1).toUpperCase()+propertieName.substring(1);
		return "get"+propertieName.substring(0,1).toUpperCase()+propertieName.substring(1);
	}



}
