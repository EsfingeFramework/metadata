package org.esfinge.metadata.container.reading;

import static org.apache.commons.beanutils.PropertyUtils.setProperty;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.esfinge.metadata.AnnotationReadingException;
import org.esfinge.metadata.container.AnnotationReadingProcessor;

public class ElementNameReadingProcessor implements AnnotationReadingProcessor {
	
	private String containerAnnotatedField;

	@Override
	public void initAnnotation(Annotation an, Field field) {
		containerAnnotatedField = field.getName();
	}

	@Override
	public void read(AnnotatedElement classWithMetadata, Object container) throws AnnotationReadingException {
		try {
			if(classWithMetadata.getClass().equals(Class.class)){
				Class<?> class1 = (Class<?>) classWithMetadata;
				setProperty(container,containerAnnotatedField,class1.getName());
			}
			else if(classWithMetadata.getClass().equals(Field.class)){
				Field field = (Field) classWithMetadata;
				setProperty(container,containerAnnotatedField,field.getName());

			}
			else if(classWithMetadata.getClass().equals(Method.class)){
				Method method = (Method) classWithMetadata;
				setProperty(container,containerAnnotatedField,method.getName());

			}
			//
		} catch (Exception e) {
			throw new AnnotationReadingException("Cannot read and record the element name",e);
		}
	}

}
