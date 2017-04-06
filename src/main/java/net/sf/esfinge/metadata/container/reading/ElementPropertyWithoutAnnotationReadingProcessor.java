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

import net.sf.esfinge.metadata.AnnotationFinder;
import net.sf.esfinge.metadata.AnnotationReader;
import net.sf.esfinge.metadata.AnnotationReadingException;
import net.sf.esfinge.metadata.AnnotationValidationException;
import net.sf.esfinge.metadata.annotation.container.ContainerFor;
import net.sf.esfinge.metadata.annotation.container.ElementPropertyWithoutAnnotation;
import net.sf.esfinge.metadata.container.AnnotationReadingProcessor;
import net.sf.esfinge.metadata.container.ContainerTarget;

public class ElementPropertyWithoutAnnotationReadingProcessor implements AnnotationReadingProcessor {

	private Field fieldAnnoted;
	private List<Object> lista;
	private Set<Object> set;
	private Map<Object, Object> map;
	private ParameterizedType fieldGenericType;
	private ElementPropertyWithoutAnnotation prop;

	@Override
	public void initAnnotation(Annotation an, AnnotatedElement elementWithMetadata) throws AnnotationValidationException {

		fieldAnnoted = (Field) elementWithMetadata;
		lista = new ArrayList<Object>();
		set = new HashSet<Object>();
		map = new HashMap<Object, Object>();
		fieldGenericType = (ParameterizedType) fieldAnnoted.getGenericType();
		prop = (ElementPropertyWithoutAnnotation) an;

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

								boolean methodValid = false;
								String methodName = propertyToGetter(field.getName());
								Method method = clazz.getDeclaredMethod(methodName);

								methodValid = AnnotationFinder.existAnnotation(method, prop.value());
								boolean fieldValid = AnnotationFinder.existAnnotation(field, prop.value());

								if (!methodValid || fieldValid) {
									AnnotationReader metadataReader = new AnnotationReader();
									Object containerField = outputClass.newInstance();
									containerField = metadataReader.readingAnnotationsTo(field, outputClass);
									lista.add(containerField);
									set.add(containerField);
									map.put(field.getName(), containerField);

								}

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
			throw new AnnotationReadingException("Cannot read and record the Element " + elementWithMetadata
					+ " in ElementPropertyWithoutAnnotationReadingProcessor in the field " + fieldAnnoted.getName(), e);
		}
	}

	public static String propertyToGetter(String propertieName) {
		return propertyToGetter(propertieName, false);
	}

	public static String propertyToGetter(String propertieName, boolean isBoolean) {
		if (isBoolean)
			return "is" + propertieName.substring(0, 1).toUpperCase() + propertieName.substring(1);
		return "get" + propertieName.substring(0, 1).toUpperCase() + propertieName.substring(1);
	}

}
