package net.sf.esfinge.metadata.container.reading;

import static org.apache.commons.beanutils.PropertyUtils.setProperty;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Map;

import net.sf.esfinge.metadata.AnnotationFinder;
import net.sf.esfinge.metadata.AnnotationReadingException;
import net.sf.esfinge.metadata.AnnotationValidationException;
import net.sf.esfinge.metadata.annotation.container.ContainerFor;
import net.sf.esfinge.metadata.annotation.container.ExecuteProcessor;
import net.sf.esfinge.metadata.annotation.container.ProcessorPerMethod;
import net.sf.esfinge.metadata.annotation.container.ProcessorType;
import net.sf.esfinge.metadata.container.AnnotationReadingProcessor;
import net.sf.esfinge.metadata.container.ContainerTarget;

public class MethodProcessorsReadingProcessor implements AnnotationReadingProcessor {

	private AnnotatedElement elementAnnoted;
	private Map<Object, Object> mapReturn, map;
	private ProcessorPerMethod processors;
	private Class<? extends Annotation> processorsAnnotationClass;
	ParameterizedType fieldGenericType;
	private Object methodReturn, invoke;;

	@Override
	public void initAnnotation(Annotation an, AnnotatedElement elementWithMetadata)
			throws AnnotationValidationException {
		elementAnnoted = elementWithMetadata;
		processors = (ProcessorPerMethod) an;
		processorsAnnotationClass = processors.configAnnotation();

		if (elementAnnoted.getClass().equals(Field.class)) {
			fieldGenericType = (ParameterizedType) ((Field) elementAnnoted).getGenericType();

		}

		map = new HashMap<>();
		mapReturn = new HashMap<>();
	}

	@Override
	public void read(AnnotatedElement elementWithMetadata, Object container, ContainerTarget target)
			throws AnnotationReadingException {
		try {
			if (target.equals(ContainerTarget.METHODS)) {
				if (elementWithMetadata instanceof Class) {
					Class clazz = (Class) elementWithMetadata;
					for (Field fieldOfClazz : clazz.getDeclaredFields()) {
						for (Annotation annotation : fieldOfClazz.getDeclaredAnnotations()) {
							setFieldOnMapWithFieldContainer(elementWithMetadata, container, fieldOfClazz, annotation);

						}
					}
				} else if (elementWithMetadata instanceof Method) {
					Field fieldOfClazz = (Field) elementWithMetadata;
					for (Annotation annotation : fieldOfClazz.getDeclaredAnnotations()) {
						// TODO REFACTOR TOTAL
						setFieldOnMapWithFieldContainer(elementWithMetadata, container, fieldOfClazz, annotation);
					}
				}

				if (processors.type() != ProcessorType.READER_ADDS_METADATA) {
					setProperty(container, ((Field) elementAnnoted).getName(), map);
				}

			} else if (target.equals(ContainerTarget.TYPE)) {
				if (elementWithMetadata instanceof Class) {
					Class clazz = (Class) elementWithMetadata;
					for (Method methodOfClazz : clazz.getDeclaredMethods()) {

						boolean existAnnotation = AnnotationFinder.existAnnotation(methodOfClazz,
								processorsAnnotationClass);

						if (existAnnotation) {
							for (Annotation annotation : methodOfClazz.getDeclaredAnnotations()) {
								setFieldOnMapWithTypeContainer(elementWithMetadata, container, methodOfClazz,
										annotation);
							}
						} else {

							for (Class superClass : clazz.getInterfaces()) {
								for (Method methodOfSuperClazz : superClass.getDeclaredMethods()) {
									for (Annotation annotation : methodOfSuperClazz.getAnnotations()) {

										setFieldOnMapWithTypeContainer(elementWithMetadata, container,
												methodOfSuperClazz, annotation);
									}
								}

							}

						}

					}
				}

			}

		} catch (Exception e) {
			throw new AnnotationReadingException("ERRO NA FUNCAO " + elementWithMetadata + ", " + container + ", " + e);
		}

	}

	private void setFieldOnMapWithTypeContainer(AnnotatedElement elementWithMetadata, Object container,
			Method methodOfClazz, Annotation annotation)
			throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException, AnnotationReadingException {
		for (Annotation processorAnnotation : AnnotationFinder.findAnnotation(annotation.annotationType(),
				processorsAnnotationClass))

		{
			Class<?> valueClass = getElementAnnoted(processorAnnotation);
			if (processors.type() == ProcessorType.READER_ADDS_METADATA) {

				findDeclaredAnnotationOnInterface(elementWithMetadata, container, annotation, valueClass, invoke);

			} else if (processors.type() == ProcessorType.READER_IS_PROCESSOR) {
				findDeclaredAnnotationOnInterface(elementWithMetadata, container, annotation, valueClass, invoke);
				map.put(methodOfClazz, invoke);
				setProperty(container, ((Field) elementAnnoted).getName(), map);

			}

			else if (processors.type() == ProcessorType.READER_RETURNS_PROCESSOR) {
				findDeclaredAnnotationOnInterface(elementWithMetadata, container, annotation, valueClass, invoke);
				map.put(methodOfClazz, methodReturn);
				setProperty(container, ((Field) elementAnnoted).getName(), map);

			}
		}

	}

	private void setFieldOnMapWithFieldContainer(AnnotatedElement elementWithMetadata, Object container,
			Field fieldOfClazz, Annotation annotation)
			throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException, AnnotationReadingException {
		for (Annotation processorAnnotation : AnnotationFinder.findAnnotation(annotation.annotationType(),
				processorsAnnotationClass)) {
			Class<?> valueClass = getElementAnnoted(processorAnnotation);
			findDeclaredAnnotationOnInterface(elementWithMetadata, container, annotation, valueClass, invoke);
			if (processors.type() == ProcessorType.READER_IS_PROCESSOR) {
				map.put(fieldOfClazz, invoke);

			} else if (processors.type() == ProcessorType.READER_RETURNS_PROCESSOR) {
				map.put(fieldOfClazz, methodReturn);
			}
		}
	}

	private Class<?> getElementAnnoted(Annotation processorAnnotation)
			throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException {
		Class<?> valueClass = (Class<?>) processorAnnotation.getClass().getDeclaredMethod("value")
				.invoke(processorAnnotation);

		invoke = valueClass.newInstance();
		return valueClass;
	}

	private void findDeclaredAnnotationOnInterface(AnnotatedElement elementWithMetadata, Object container,
			Annotation annotation, Class<?> valueClass, Object objectToInvoke)
			throws IllegalAccessException, InvocationTargetException, AnnotationReadingException {
		for (Method methodToInvoke : valueClass.getInterfaces()[0].getDeclaredMethods()) {
			if (methodToInvoke.isAnnotationPresent(ExecuteProcessor.class)) {
				executeParameters(elementWithMetadata, container, annotation, objectToInvoke, methodToInvoke);
			}
		}
	}

	private void executeParameters(AnnotatedElement elementWithMetadata, Object container, Annotation annotation,
			Object objectToInvoke, Method methodToInvoke) throws IllegalAccessException, InvocationTargetException, AnnotationReadingException {
		Object[] args = new Object[methodToInvoke.getParameters().length];
		int cont = 0;
		for (Parameter p1 : methodToInvoke.getParameters()) {

			if (p1.getType().equals(Annotation.class)) {
				args[cont] = annotation;
			} else if (p1.getType().equals(Object.class)) {
				args[cont] = container;

			} else if (p1.getType().equals(AnnotatedElement.class)) {
				args[cont] = elementWithMetadata;
			} else if (AnnotationFinder.existAnnotation(p1.getType(), ContainerFor.class)) {
				args[cont] = container;
			}

			cont++;
		}
		if (methodToInvoke.invoke(objectToInvoke, args) != null) {
			methodReturn = methodToInvoke.invoke(objectToInvoke, args);
		}
	}

}
