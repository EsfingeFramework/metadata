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
import net.sf.esfinge.metadata.annotation.container.ExecuteProcessor;
import net.sf.esfinge.metadata.annotation.container.ProcessorPerField;
import net.sf.esfinge.metadata.annotation.container.ProcessorType;
import net.sf.esfinge.metadata.container.AnnotationReadingProcessor;
import net.sf.esfinge.metadata.container.ContainerTarget;

public class FieldProcessorsReadingProcessor implements AnnotationReadingProcessor {

	private Field fieldAnnoted;
	private Map<Object, Object> map;
	private ProcessorPerField processors;
	private Class<? extends Annotation> processorsAnnotationClass;
	ParameterizedType fieldGenericType;
	private Object methodReturn, invoke;

	@Override
	public void initAnnotation(Annotation an, AnnotatedElement elementWithMetadata) throws AnnotationValidationException {
		fieldAnnoted = (Field) elementWithMetadata;
		processors = (ProcessorPerField) an;
		processorsAnnotationClass = processors.configAnnotation();
		fieldGenericType = (ParameterizedType) fieldAnnoted.getGenericType();
		map = new HashMap<>();
	}

	@Override
	public void read(AnnotatedElement elementWithMetadata, Object container, ContainerTarget target)
			throws AnnotationReadingException {
		try {
			if (elementWithMetadata instanceof Class) {
				Class clazz = (Class) elementWithMetadata;
				for (Field fieldOfClazz : clazz.getDeclaredFields()) {
					for (Annotation annotation : fieldOfClazz.getDeclaredAnnotations()) {
						// TODO REFACTOR TOTAL
						for (Annotation processorAnnotation : AnnotationFinder
								.findAnnotation(annotation.annotationType(), processorsAnnotationClass)) {
							
							Class<?> valueClass = (Class<?>) processorAnnotation.getClass().getDeclaredMethod("value")
									.invoke(processorAnnotation);

							invoke = valueClass.newInstance();
							findDeclaredAnnotationOnInterface(elementWithMetadata, container, annotation, valueClass,
									invoke);
							if (processors.type() == ProcessorType.READER_ADDS_PROCESSOR) {
								map.put(fieldOfClazz, invoke);

							} else if (processors.type() == ProcessorType.READER_RETURNS_PROCESSOR) {
								map.put(fieldOfClazz, methodReturn);
							}
						}

					}
				}
			} else if (elementWithMetadata instanceof Field) {
				Field fieldOfClazz = (Field) elementWithMetadata;
				for (Annotation annotation : fieldOfClazz.getDeclaredAnnotations()) {
					// TODO REFACTOR TOTAL
					for (Annotation processorAnnotation : AnnotationFinder.findAnnotation(annotation.annotationType(),
							processorsAnnotationClass)) {
						// pega o class do value dessa anotation
						Class<?> valueClass = (Class<?>) processorAnnotation.getClass().getDeclaredMethod("value")
								.invoke(processorAnnotation);
						// cria um objeto dessa classe e invoca o @InitProcessor
						invoke = valueClass.newInstance();
						findDeclaredAnnotationOnInterface(elementWithMetadata, container, annotation, valueClass,
								invoke);
						if (processors.type() == ProcessorType.READER_ADDS_PROCESSOR) {
							map.put(fieldOfClazz, invoke);
						} else if (processors.type() == ProcessorType.READER_RETURNS_PROCESSOR) {
							map.put(fieldOfClazz, methodReturn);
						}
					}

				}
			}
			setProperty(container, fieldAnnoted.getName(), map);

		} catch (Exception e) {
			throw new AnnotationReadingException("===========" + e);
		}

	}

	private void findDeclaredAnnotationOnInterface(AnnotatedElement elementWithMetadata, Object container,
			Annotation annotation, Class<?> valueClass, Object objectToInvoke)
			throws IllegalAccessException, InvocationTargetException {
		for (Method methodToInvoke : valueClass.getInterfaces()[0].getDeclaredMethods()) {
			if (methodToInvoke.isAnnotationPresent(ExecuteProcessor.class)) {
				executeParameters(elementWithMetadata, container, annotation, objectToInvoke, methodToInvoke);
			}
		}
	}

	private void executeParameters(AnnotatedElement elementWithMetadata, Object container, Annotation annotation,
			Object objectToInvoke, Method methodToInvoke) throws IllegalAccessException, InvocationTargetException {
		Object[] args = new Object[methodToInvoke.getParameters().length];
		int cont = 0;
		for (Parameter p1 : methodToInvoke.getParameters()) {
			
			if (p1.getType().equals(Annotation.class)) 
			{ 
				args[cont] = annotation;
			} else if (p1.getType() instanceof AnnotatedElement) {
				args[cont] = elementWithMetadata;
			} else if (p1.getType().equals(container.getClass())) {
				args[cont] = container;
			}
			cont++;
		}
		for (Object object : args) {
		}
		if(methodToInvoke.invoke(objectToInvoke, args)!=null){
			methodReturn = methodToInvoke.invoke(objectToInvoke, args);
		}		
	}

}