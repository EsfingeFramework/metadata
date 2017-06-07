package net.sf.esfinge.metadata.container.reading;

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
import java.util.Map;
import java.util.Set;

import net.sf.esfinge.metadata.AnnotationFinder;
import net.sf.esfinge.metadata.AnnotationReader;
import net.sf.esfinge.metadata.AnnotationReadingException;
import net.sf.esfinge.metadata.AnnotationValidationException;
import net.sf.esfinge.metadata.annotation.container.AnnotationPropertyLocation;
import net.sf.esfinge.metadata.annotation.container.ContainerFor;
import net.sf.esfinge.metadata.annotation.container.ElementProperty;
import net.sf.esfinge.metadata.container.AnnotationReadingProcessor;
import net.sf.esfinge.metadata.container.ContainerTarget;

public class ElementPropertyReadingProcessorNew implements AnnotationReadingProcessor {

	private Field fieldAnnoted;
	private List<Object> listOfProperty;
	private Set setObject;
	private Map<Object, Object> map;
	private ParameterizedType fieldGenericType;
	private ElementProperty annotation;
	@Override
	public void initAnnotation(Annotation an, AnnotatedElement fieldWithMetadata) throws AnnotationValidationException {

		fieldAnnoted = (Field) fieldWithMetadata;
		listOfProperty = new ArrayList<Object>();
		setObject = new HashSet<>();
		map = new HashMap<>();
		fieldGenericType = (ParameterizedType) fieldAnnoted.getGenericType();
		annotation = (ElementProperty) an;

	}

	public void read(AnnotatedElement elementWithMetadata, Object container, ContainerTarget target)
			throws AnnotationReadingException {
		try {
			AnnotationReader ar = new AnnotationReader();
			Class<?> annotedClass =null;
			Class<?> genericType = null;
			Object containerElement = null;
			if(elementWithMetadata instanceof Class)
			{
				 annotedClass = (Class<?>) elementWithMetadata;

				if(fieldGenericType.getRawType().equals(List.class))
				{
					genericType = (Class<?>) fieldGenericType.getActualTypeArguments()[0];
					containerElement = genericType.newInstance();
				}
				else if(fieldGenericType.getRawType().equals(Set.class))
				{
					genericType = (Class<?>) fieldGenericType.getActualTypeArguments()[0];
					containerElement = genericType.newInstance();
				}
				else if(fieldGenericType.getRawType().equals(Map.class))
				{
					genericType = (Class<?>) fieldGenericType.getActualTypeArguments()[1];
					containerElement = genericType.newInstance();
				}
				
			}
			
			if (target == ContainerTarget.TYPE) {
				AnnotationPropertyLocation property = annotation.property();
				if(property.isSearchField())
				{
					for (Field annotedField : annotedClass.getDeclaredFields()) {
	
							containerElement = ar.readingAnnotationsTo(annotedField, genericType);
							listOfProperty.add(containerElement);
							setObject.add(containerElement);
							map.put(annotedField.getName(), containerElement);
							
						
					}
					
				}
				if(property.isSearchGetter())
				{
					for(Method annotedMethod: annotedClass.getDeclaredMethods())
					{


						if((annotedMethod.getName().contains("get"))||(annotedMethod.getName().contains("is")))
						{
							
								containerElement = ar.readingAnnotationsTo(annotedMethod, genericType);

								listOfProperty.add(containerElement);
								setObject.add(containerElement);
								map.put(annotedMethod.getName(), containerElement);
							
						}
						
						
					}
				}
				if(property.isSearchSetter())
				{
					for(Method annotedMethod: annotedClass.getDeclaredMethods())
					{
						if(annotedMethod.getName().contains("set"))
						{

								containerElement = ar.readingAnnotationsTo(annotedMethod, genericType);
								listOfProperty.add(containerElement);
								setObject.add(containerElement);
								map.put(annotedMethod.getName(), containerElement);

						}
						
						
					}
				}
				addToContainer(container);
			}
			
			
		} catch (Exception e) {
			throw new AnnotationReadingException(
					"Cannot read and record the ElementPropertyReadingProcessor in the field " + fieldAnnoted.getName(),
					e);
		}
	}

	
	
		
	private void addToContainer(Object container)
			throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		if (fieldAnnoted.getType().equals(List.class)) {
			setProperty(container, fieldAnnoted.getName(), listOfProperty);
		} else if (fieldAnnoted.getType().equals(Set.class)) {
			setProperty(container, fieldAnnoted.getName(), setObject);
		} else if (fieldAnnoted.getType().equals(Map.class)) {
			setProperty(container, fieldAnnoted.getName(), map);
		}
	}

}
