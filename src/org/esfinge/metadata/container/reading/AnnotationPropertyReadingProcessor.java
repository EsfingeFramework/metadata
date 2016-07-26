package org.esfinge.metadata.container.reading;

import static org.apache.commons.beanutils.PropertyUtils.setProperty;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.esfinge.metadata.AnnotationFinder;
import org.esfinge.metadata.AnnotationReadingException;
import org.esfinge.metadata.annotation.container.AnnotationProperty;
import org.esfinge.metadata.container.AnnotationReadingProcessor;
import org.esfinge.metadata.container.ContainerTarget;

public class AnnotationPropertyReadingProcessor implements AnnotationReadingProcessor {
	
	private Field fieldAnnoted;
	private Class<? extends Annotation> annotationThatNeedToContains;
	private AnnotationProperty  annot;

	@Override
	public void initAnnotation(Annotation an, Field field) {
		
		fieldAnnoted = field;
		annot =(AnnotationProperty)an;		
		annot.property();
		annotationThatNeedToContains = annot.annotation();
	}

	@Override
	public void read(AnnotatedElement elementWithMetadata, Object container, ContainerTarget enumStr) throws AnnotationReadingException {
		try {
			if (AnnotationFinder.existAnnotation(elementWithMetadata,annotationThatNeedToContains)){
				
				Annotation annotation = elementWithMetadata.getAnnotation(annotationThatNeedToContains);
				
				for(Method methodAnotation: annotation.annotationType().getDeclaredMethods()){
					if(methodAnotation.getName().equals(annot.property())){
						setProperty(container, fieldAnnoted.getName(),methodAnotation.invoke(annotation));
					}
						
				}
			}
		} catch (Exception e) {
			throw new AnnotationReadingException("Cannot read and record the AnnotationProperty: /n As field"+ fieldAnnoted+"annotation " + annotationThatNeedToContains.getName(),e);
		}
	}

}
