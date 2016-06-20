package org.esfinge.metadata.container;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import static org.esfinge.metadata.AnnotationFinder.findAnnotation;
import org.esfinge.metadata.TestAnottation.Tabela;
import org.esfinge.metadata.locate.MetadataLocator;
import org.esfinge.metadata.locate.RegularLocator;
import org.esfinge.metadata.validate.MetadataValidator;

import static org.apache.commons.beanutils.PropertyUtils.*;

//import java.util.ArrayList;

public class LeitorMetadados {
	
	//To be modified as necessary. Currently only checks if BooleanAnnotation is present on methods.
	//TODO:Checking on classes and parameters
	

	public <E> E lerMetadadosDePara(Class<?> classWithMetadata, Class<E> containerClass) throws Exception {

		Object container = containerClass.newInstance();
				//Annotation field
		for (Field field: containerClass.getDeclaredFields())
		{			
			containsAnnotation(classWithMetadata, container, field);
			elementName(classWithMetadata, container, field);
			reflectionReference(classWithMetadata, container, field);
			annotationProperty(classWithMetadata, container, field);
			processMethods(classWithMetadata, container, field);
			processFields(classWithMetadata, container, field);

		}
		
		return (E) container;
	}

	private void processMethods(Class<?> classWithMetadata, Object container, Field field)
			throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		if(field.isAnnotationPresent(ProcessMethods.class)){
			//codigo
			List<Object> lista = new ArrayList<Object>();
		    ParameterizedType fieldGenericType =(ParameterizedType)field.getGenericType();
		    for (Type t1 : fieldGenericType.getActualTypeArguments()) {
				Class <?> outputClass =(Class<?>)t1;
				
				
				for(Method m1: classWithMetadata.getDeclaredMethods()){
					Object containerMethods = outputClass.newInstance();
					for(Field outputField: outputClass.getDeclaredFields())
					{
						
						containsAnnotation(m1, containerMethods, outputField);						
						if(outputField.isAnnotationPresent(ElementName.class))
						{
							
							setProperty(containerMethods,outputField.getName(),m1.getName());
						
						}
					}
					lista.add(containerMethods);						
				}
				setProperty(container,field.getName(),lista);
				
				//
			}
		}
	}
	
	private void processFields(Class<?> classWithMetadata, Object container, Field field)
			throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		if(field.isAnnotationPresent(ProcessFields.class)){
			//codigo
			List<Object> lista = new ArrayList<Object>();
		    ParameterizedType fieldGenericType =(ParameterizedType)field.getGenericType();
		    for (Type t1 : fieldGenericType.getActualTypeArguments()) {
				Class <?> outputClass =(Class<?>)t1;
				
				
				for(Field m1: classWithMetadata.getDeclaredFields()){
					Object containerMethods = outputClass.newInstance();
					for(Field outputField: outputClass.getDeclaredFields())
					{
						
						containsAnnotation(m1, containerMethods, outputField);						
						if(outputField.isAnnotationPresent(ElementName.class))
						{
							
							setProperty(containerMethods,outputField.getName(),m1.getName());
						
						}
					}
					lista.add(containerMethods);						
				}
				setProperty(container,field.getName(),lista);
				
				//
			}
		}
	}

	
	private void annotationProperty(Class<?> classWithMetadata, Object container, Field field)
			throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		if(field.isAnnotationPresent(AnnotationProperty.class))
		{
			AnnotationProperty annotP= field.getAnnotation(AnnotationProperty.class);
			
			Class<? extends Annotation> annotationThatNeedToContains = annotP.annotation();
			if (classWithMetadata.isAnnotationPresent(annotationThatNeedToContains)){
				
				Annotation annotation = classWithMetadata.getAnnotation(annotationThatNeedToContains);
				
				for(Method methodAnotation: annotation.annotationType().getDeclaredMethods()){
					if(methodAnotation.getName().equals(annotP.property())){
						setProperty(container, field.getName(),methodAnotation.invoke(annotation));
					}
						
				}
			}

		}
	}

	private void reflectionReference(Class<?> classWithMetadata, Object container, Field field)
			throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		if(field.isAnnotationPresent(ReflectionReference.class))
		{
			setProperty(container, field.getName(),classWithMetadata);
		}
	}

	private void elementName(Class<?> classWithMetadata, Object container, Field field)
			throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		if(field.isAnnotationPresent(ElementName.class))
		{
			setProperty(container,field.getName(),classWithMetadata.getName());
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

