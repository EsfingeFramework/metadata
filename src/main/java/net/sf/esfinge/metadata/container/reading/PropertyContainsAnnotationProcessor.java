package net.sf.esfinge.metadata.container.reading;

import static org.apache.commons.beanutils.PropertyUtils.setProperty;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import net.sf.esfinge.metadata.AnnotationFinder;
import net.sf.esfinge.metadata.AnnotationReadingException;
import net.sf.esfinge.metadata.annotation.container.PropertyContainsAnnotation;
import net.sf.esfinge.metadata.container.AnnotationReadingProcessor;
import net.sf.esfinge.metadata.container.ContainerTarget;

public class PropertyContainsAnnotationProcessor implements AnnotationReadingProcessor{

	PropertyContainsAnnotation annot;
	private String containerAnnotatedField;
	
	@Override
	public void initAnnotation(Annotation an, AnnotatedElement elementWithMetadata) {
		containerAnnotatedField = ((Field) elementWithMetadata).getName();
		annot =(PropertyContainsAnnotation)an;
	}

	@Override
	public void read(AnnotatedElement elementWithMetadata, Object container,ContainerTarget enumStr) throws AnnotationReadingException {
		try {
			
			Class<? extends Annotation> annotationThatNeedToContains = annot.value();
			
			if(AnnotationFinder.existAnnotation(elementWithMetadata,annotationThatNeedToContains))
			{
				setProperty(container, containerAnnotatedField,	AnnotationFinder.existAnnotation(elementWithMetadata,annotationThatNeedToContains));
			}
			else if(elementWithMetadata.getClass().equals(Field.class))
			{
				Class<?> clazz = ((Field) elementWithMetadata).getDeclaringClass();
				Method method = clazz.getMethod(propertyToGetter(((Field) elementWithMetadata).getName()));
				setProperty(container, containerAnnotatedField,	AnnotationFinder.existAnnotation(method,annotationThatNeedToContains));

			}
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
