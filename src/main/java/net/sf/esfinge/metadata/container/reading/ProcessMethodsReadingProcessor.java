package net.sf.esfinge.metadata.container.reading;

import static org.apache.commons.beanutils.PropertyUtils.setProperty;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.sf.esfinge.metadata.AnnotationReader;
import net.sf.esfinge.metadata.AnnotationReadingException;
import net.sf.esfinge.metadata.annotation.container.ContainerFor;
import net.sf.esfinge.metadata.container.AnnotationReadingProcessor;
import net.sf.esfinge.metadata.container.ContainerTarget;

public class ProcessMethodsReadingProcessor implements AnnotationReadingProcessor {

	private Field fieldAnnoted;
	List<Object> lista;
	Set<Object> set;
	Map<Object,Object> map;
	ParameterizedType fieldGenericType;

	@Override
	public void initAnnotation(Annotation an, Field field) {

		fieldAnnoted = field;
		lista = new ArrayList<Object>();
		set = new HashSet<Object>();
		map = new HashMap<>();
		fieldGenericType = (ParameterizedType) field.getGenericType();

	}

	@Override
	public void read(AnnotatedElement elementWithMetadata, Object container, ContainerTarget target) throws AnnotationReadingException {
		try {
			if (target == ContainerTarget.CLASS) {
				Class<?> clazz = (Class<?>) elementWithMetadata;
				for (Type t1 : fieldGenericType.getActualTypeArguments()){
					Class <?> outputClass =(Class<?>)t1;			
					if(!outputClass.equals(Method.class))
					{
						ContainerFor containerFor = (ContainerFor)outputClass.getDeclaredAnnotation(ContainerFor.class);
						if(!containerFor.value().equals(ContainerTarget.METHODS))
						{
							throw new Exception("ContainerFor: " +containerFor.value() +" no same of METHODS");
						}

						for(Method m1: clazz.getDeclaredMethods())
						{
							AnnotationReader metadataReader = new AnnotationReader();
							Object containerField = outputClass.newInstance();
							containerField = metadataReader.readingAnnotationsTo(m1, outputClass);
							lista.add(containerField);
							set.add(containerField);
							map.put(m1, containerField);
						}			
						if(fieldAnnoted.getType().equals(List.class)){
							setProperty(container,fieldAnnoted.getName(),lista);
						}
						else if(fieldAnnoted.getType().equals(Set.class)){
							setProperty(container,fieldAnnoted.getName(),set);
						}
						else if(fieldAnnoted.getType().equals(Map.class)){
							setProperty(container,fieldAnnoted.getName(),map);
						}

					}
				}
			}
		} catch (Exception e) {
			throw new AnnotationReadingException("Cannot read and record the processMethods in the field "+ fieldAnnoted.getName(), e);
		}
	}

}
