package org.esfinge.metadata.container.reading;

import static org.apache.commons.beanutils.PropertyUtils.setProperty;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.esfinge.metadata.AnnotationReadingException;
import org.esfinge.metadata.container.AnnotationProperty;
import org.esfinge.metadata.container.AnnotationReadingProcessor;
import org.esfinge.metadata.container.ContainsAnnotation;

public class AnnotationPropertyReadingProcessor implements AnnotationReadingProcessor {
	
	private Field fieldAnnoted;
	private Class<? extends Annotation> annotationThatNeedToContains;
	private String value;
	private AnnotationProperty  annot;

	@Override
	public void initAnnotation(Annotation an, Field field) {
		
		fieldAnnoted = field;
		annot =(AnnotationProperty)an;		
		value = annot.property();
		annotationThatNeedToContains = annot.annotation();
	}

	@Override
	public void read(Class<?> classWithMetadata, Object container) throws AnnotationReadingException {
		try {
			if (classWithMetadata.isAnnotationPresent(annotationThatNeedToContains)){
				
				Annotation annotation = classWithMetadata.getAnnotation(annotationThatNeedToContains);
				
				for(Method methodAnotation: annotation.annotationType().getDeclaredMethods()){
					if(methodAnotation.getName().equals(annot.property())){
						setProperty(container, fieldAnnoted.getName(),methodAnotation.invoke(annotation));
					}
						
				}
			}
		} catch (Exception e) {
			throw new AnnotationReadingException("Cannot read and record the element name",e);
		}
	}

}
