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
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.esfinge.metadata.AnnotationReadingException;
import org.esfinge.metadata.annotation.container.AllMethodsWith;
import org.esfinge.metadata.annotation.container.AnnotationProperty;
import org.esfinge.metadata.annotation.container.ContainerFor;
import org.esfinge.metadata.annotation.container.ContainsAnnotation;
import org.esfinge.metadata.annotation.container.ElementName;
import org.esfinge.metadata.annotation.container.ProcessMethods;
import org.esfinge.metadata.AnnotationReader;
import org.esfinge.metadata.container.AnnotationReadingProcessor;
import org.esfinge.metadata.container.ContainerTarget;

public class AllMethodsWithReadingProcessor implements AnnotationReadingProcessor {

	private Field fieldAnnoted;
	List<Object> lista;
	Set<Object> set;
	ParameterizedType fieldGenericType;
	AllMethodsWith annotation;

	@Override
	public void initAnnotation(Annotation an, Field field) {

		fieldAnnoted = field;
		lista = new ArrayList<Object>();
		set=  new HashSet<Object>();
		fieldGenericType = (ParameterizedType) field.getGenericType();
		annotation = fieldAnnoted.getDeclaredAnnotation(AllMethodsWith.class);
	}

	@Override
	public void read(AnnotatedElement elementWithMetadata, Object container, ContainerTarget target) throws AnnotationReadingException {
		try {
			if (target == ContainerTarget.CLASS) {
				Class<?> clazz = (Class<?>) elementWithMetadata;
				for (Type t1 : fieldGenericType.getActualTypeArguments()){
					Class <?> outputClass =(Class<?>)t1;
					ContainerFor containerFor = (ContainerFor) outputClass.getDeclaredAnnotation(ContainerFor.class);
					if(!containerFor.vaule().equals(ContainerTarget.METHODS))
					{
						throw new Exception("ContainerFor: " +containerFor.vaule() +" no same of METHODS");
					}

					for(Method m1: clazz.getDeclaredMethods())
					{
						if(m1.isAnnotationPresent(annotation.value()))
						{
							AnnotationReader metadataReader = new AnnotationReader();
							Object containerField = outputClass.newInstance();
							containerField = metadataReader.readingAnnotationsTo(m1, outputClass);
							lista.add(containerField);
							set.add(containerField);
						}
					}
					
					if(fieldAnnoted.getType().equals(List.class)){
						setProperty(container,fieldAnnoted.getName(),lista);
					}
					else if(fieldAnnoted.getType().equals(Set.class)){
						setProperty(container,fieldAnnoted.getName(),set);
					}
				}					
			}

		} catch (Exception e) {
			throw new AnnotationReadingException("Cannot read and record the allMethodsWithMetadata", e);
		}

	}

}
