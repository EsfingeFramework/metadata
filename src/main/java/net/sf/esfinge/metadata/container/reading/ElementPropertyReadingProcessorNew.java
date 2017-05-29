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
	private Set<Object> set;
	private Map<Object, Object> map;
	private ParameterizedType fieldGenericType;
	private ElementProperty annotation;
	@Override
	public void initAnnotation(Annotation an, AnnotatedElement fieldWithMetadata) throws AnnotationValidationException {

		fieldAnnoted = (Field) fieldWithMetadata;
		listOfProperty = new ArrayList<Object>();
		set = new HashSet<Object>();
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
			System.out.println("AQUIIII");
			if(elementWithMetadata instanceof Class)
			{
				 annotedClass = (Class<?>) elementWithMetadata;

				if(fieldGenericType.getRawType().equals(List.class))
				{
					genericType = (Class<?>) fieldGenericType.getActualTypeArguments()[0];
					containerElement = genericType.newInstance();
				}
				else if(fieldGenericType.getRawType().equals(Map.class))
				{
					System.out.println("=============================");
					genericType = (Class<?>) fieldGenericType.getActualTypeArguments()[1];
					System.out.println(genericType);
					containerElement = genericType.newInstance();
					System.out.println("=============================");
				}
				
			}
			
			if (target == ContainerTarget.TYPE) {
				AnnotationPropertyLocation property = annotation.property();
				System.out.println("IF TYPE");
				if(property.isSearchField())
				{
					System.out.println("IF isSearchField");
					for (Field annotedField : annotedClass.getDeclaredFields()) {
				
						
						System.out.println("==isSearchField=");
						System.out.println(annotedField);
						System.out.println(annotedField.getDeclaredAnnotations().length);
						System.out.println("==isSearchField=");
						
						for(Annotation annotations:annotedField.getDeclaredAnnotations())
						{
							

							containerElement = ar.readingAnnotationsTo(annotedField, genericType);
							listOfProperty.add(containerElement);
							set.add(containerElement);
							map.put(annotedField.getName(), containerElement);
						}
					}
					
				}
				if(property.isSearchGetter())
				{
					for(Method annotedMethod: annotedClass.getDeclaredMethods())
					{


						if((annotedMethod.getName().contains("get"))||(annotedMethod.getName().contains("is")))
						{
							System.out.println("==isSearchMethod=");
							System.out.println(annotedMethod);
							System.out.println(annotedMethod.getDeclaredAnnotations().length);
							System.out.println("==isSearchMethod=");

							for(Annotation annotations:annotedMethod.getDeclaredAnnotations())
							{
								System.out.println("--------------------------------------------");
								containerElement = ar.readingAnnotationsTo(annotedMethod, genericType);

								listOfProperty.add(containerElement);
								set.add(containerElement);
								map.put(annotedMethod.getName(), containerElement);
								System.out.println(map.toString());
							}
							
						}
						
						
					}
				}
				if(property.isSearchSetter())
				{
					for(Method annotedMethod: annotedClass.getDeclaredMethods())
					{
						if(annotedMethod.getName().contains("set"))
						{
							for(Annotation annotations:annotedMethod.getDeclaredAnnotations())
							{
								containerElement = ar.readingAnnotationsTo(annotedMethod, genericType);
								listOfProperty.add(containerElement);
								set.add(containerElement);
								map.put(annotedMethod.getName(), containerElement);
							}
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
			setProperty(container, fieldAnnoted.getName(), set);
		} else if (fieldAnnoted.getType().equals(Map.class)) {
			setProperty(container, fieldAnnoted.getName(), map);
		}
	}

}
