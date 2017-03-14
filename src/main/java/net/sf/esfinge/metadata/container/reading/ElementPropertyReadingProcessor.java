package net.sf.esfinge.metadata.container.reading;

import static org.apache.commons.beanutils.PropertyUtils.setProperty;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
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
import net.sf.esfinge.metadata.annotation.container.ContainerFor;
import net.sf.esfinge.metadata.container.AnnotationReadingProcessor;
import net.sf.esfinge.metadata.container.ContainerTarget;

public class ElementPropertyReadingProcessor implements AnnotationReadingProcessor {

	private Field fieldAnnoted;
	private List<Object> lista;
	private Set<Object> set;
	private Map<Object, Object> map;
	private ParameterizedType fieldGenericType;

	@Override
	public void initAnnotation(Annotation an, Field field) throws AnnotationValidationException {

		fieldAnnoted = field;
		lista = new ArrayList<Object>();
		set = new HashSet<Object>();
		map = new HashMap<>();
		fieldGenericType = (ParameterizedType) field.getGenericType();

	}

	public void read(AnnotatedElement elementWithMetadata, Object container, ContainerTarget target)
			throws AnnotationReadingException {
		try {
			if (target == ContainerTarget.TYPE) {
				Class<?> clazz = (Class<?>) elementWithMetadata;
				for (Type t1 : fieldGenericType.getActualTypeArguments()) {
					Class<?> outputClass = (Class<?>) t1;
					if (!outputClass.equals(String.class)) {

						for (Annotation ann : AnnotationFinder.findAnnotation(outputClass, ContainerFor.class)) {
							ContainerFor containerFor = (ContainerFor) ann;
							if (!containerFor.value().equals(ContainerTarget.ALL)) {
								throw new Exception("ContainerFor: " + containerFor.value() + " no same of ALL");
							}

							for (Field field : clazz.getDeclaredFields()) {

								AnnotationReader metadataReader = new AnnotationReader();
								Object containerField = outputClass.newInstance();
								containerField = metadataReader.readingAnnotationsTo(field, outputClass);
								lista.add(containerField);
								set.add(containerField);
								map.put(field.getName(), containerField);

							}
							if (fieldAnnoted.getType().equals(List.class)) {
								setProperty(container, fieldAnnoted.getName(), lista);
							} else if (fieldAnnoted.getType().equals(Set.class)) {
								setProperty(container, fieldAnnoted.getName(), set);
							} else if (fieldAnnoted.getType().equals(Map.class)) {
								setProperty(container, fieldAnnoted.getName(), map);
							}

						}
					}
				}
			}
		} catch (Exception e) {
			throw new AnnotationReadingException(
					"Cannot read and record the ElementPropertyReadingProcessor in the field " + fieldAnnoted.getName(),
					e);
		}
	}

}
