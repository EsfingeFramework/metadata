package org.esfinge.metadata.container.reading;

import static org.apache.commons.beanutils.PropertyUtils.setProperty;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.esfinge.metadata.AnnotationReadingException;
import org.esfinge.metadata.container.AnnotationProperty;
import org.esfinge.metadata.container.AnnotationReadingProcessor;
import org.esfinge.metadata.container.ContainsAnnotation;
import org.esfinge.metadata.container.ElementName;
import org.esfinge.metadata.container.ProcessFields;
import org.esfinge.metadata.container.ProcessMethods;

public class ProcessFieldsReadingProcessor implements AnnotationReadingProcessor {
	
	private Field fieldAnnoted;
	private String value;
	private ProcessFields  annot;
	List<Object> lista;
	ParameterizedType fieldGenericType;

	@Override
	public void initAnnotation(Annotation an, Field field) {
		
		fieldAnnoted = field;
		annot =(ProcessFields)an;		
		lista = new ArrayList<Object>();
		fieldGenericType =(ParameterizedType)field.getGenericType();
		
	}

	@Override
	public void read(Class<?> classWithMetadata, Object container) throws AnnotationReadingException {
		try {
				
			for (Type t1 : fieldGenericType.getActualTypeArguments()) {
				Class <?> outputClass =(Class<?>)t1;
				
				for(Field f1: classWithMetadata.getDeclaredFields()){
					Object containerFields = outputClass.newInstance();
					for(Field outputField: outputClass.getDeclaredFields())
					{
						
						containsAnnotation(f1, containerFields, outputField);						
						if(outputField.isAnnotationPresent(ElementName.class))
						{
							
							setProperty(containerFields,outputField.getName(),f1.getName());
						
						}
					}
					lista.add(containerFields);						
				}
				setProperty(container,fieldAnnoted.getName(),lista);
				
				//
			}		
		
		} catch (Exception e) {
			throw new AnnotationReadingException("Cannot read and record the element name",e);
		}
	}
	private void containsAnnotation(AnnotatedElement classWithMetadata, Object container, Field field)
			throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		if(field.isAnnotationPresent(ContainsAnnotation.class)){
			ContainsAnnotation annot = field.getAnnotation(ContainsAnnotation.class);
			Class<? extends Annotation> annotationThatNeedToContains = annot.value();
			setProperty(container,field.getName(), classWithMetadata.isAnnotationPresent(annotationThatNeedToContains));
			//field.set(container, classWithMetadata.isAnnotationPresent(annotationThatNeedToContains));
		}
	} 	


}
