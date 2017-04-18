package net.sf.esfinge.metadata.container.reading;

import static org.apache.commons.beanutils.PropertyUtils.setProperty;

import java.awt.Container;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import net.sf.esfinge.metadata.AnnotationFinder;
import net.sf.esfinge.metadata.AnnotationReadingException;
import net.sf.esfinge.metadata.AnnotationValidationException;
import net.sf.esfinge.metadata.annotation.container.ExecuteProcessor;
import net.sf.esfinge.metadata.annotation.container.ProcessorType;
import net.sf.esfinge.metadata.annotation.container.CustomReader;
import net.sf.esfinge.metadata.container.AnnotationReadingProcessor;
import net.sf.esfinge.metadata.container.ContainerTarget;

public class ProcessorsReadingProcessor implements AnnotationReadingProcessor{

	private AnnotatedElement elementAnnoted;
	private Field fieldAnnoted;
	private List<Object> list;
	private CustomReader processors;
	private Class<? extends Annotation> processorsAnnotationClass;
	Type fieldGenericType;
	private Object returnInvoke;
	private ContainerTarget target;

	@Override
	public void initAnnotation(Annotation an, AnnotatedElement elementWithMetadata) throws AnnotationValidationException {
		
		
		elementAnnoted = elementWithMetadata;
		processors = (CustomReader)an;
		processorsAnnotationClass = processors.configAnnotation();
		if(elementAnnoted instanceof Field)
		{
			fieldAnnoted = (Field) elementAnnoted;
			fieldGenericType =  fieldAnnoted.getGenericType();
		}
		list = new ArrayList<Object>();		
	}

	@Override
	public void read(AnnotatedElement elementWithMetadata, Object container, ContainerTarget target)
			throws AnnotationReadingException {
		try{		
			this.target = target;
			annotationSearch(elementWithMetadata, container);
			if(processors.type()!=ProcessorType.READER_ADDS_METADATA)
			{
				setProperty(container,fieldAnnoted.getName(),list);
			}
		}
		catch (Exception e) {
			throw new AnnotationReadingException(e);
		}
		
	}

	private void annotationSearch(AnnotatedElement elementWithMetadata, Object container)
			throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException {
		for (Annotation annotation : elementWithMetadata.getAnnotations()) {
			if(AnnotationFinder.existAnnotation(annotation.annotationType(),processorsAnnotationClass)){
				Annotation processorAnnotation = annotation.annotationType().getAnnotation(processorsAnnotationClass);
				//O ERRO ESTÁ AQUIII
				Class<?> valueClass = (Class<?>) processorAnnotation.getClass().getDeclaredMethod(processors.readerConfig()).invoke(processorAnnotation);
				
				//O ERRO ESTÁ AQUIII
				Object objectToInvoke = valueClass.newInstance();

				
				findDeclaredAnnotationOnInterface(elementWithMetadata, container, annotation, valueClass,
						objectToInvoke);
				
				if(processors.type() == ProcessorType.READER_IS_PROCESSOR){
					list.add(objectToInvoke);

				}
				else if(processors.type() == ProcessorType.READER_RETURNS_PROCESSOR){
					list.add(returnInvoke);
				}
			}
		}
	}

	private void findDeclaredAnnotationOnInterface(AnnotatedElement elementWithMetadata, Object container,
			Annotation annotation, Class<?> valueClass, Object objectToInvoke)
			throws IllegalAccessException, InvocationTargetException {
		for(Class<?> interfaces : valueClass.getInterfaces())
		{
			for(Method methodToInvoke: interfaces.getDeclaredMethods())
			{
				//Retorna um array list com os metodos anotados com o @InitProcessor
				if(AnnotationFinder.existAnnotation(methodToInvoke, ExecuteProcessor.class)){
					executeParameters(elementWithMetadata, container, annotation, objectToInvoke,
							methodToInvoke);
				}
			}
		}
	}

	private void executeParameters(AnnotatedElement elementWithMetadata, Object container, Annotation annotation,
			Object objectToInvoke ,Method methodToInvoke)
			throws IllegalAccessException, InvocationTargetException {
		Object[] args = new Object[methodToInvoke.getParameters().length];
		int cont = 0;
		for(Parameter parameterMethod : methodToInvoke.getParameters()){
			if(parameterMethod.getType().equals(Annotation.class))
			{
				args[cont] = annotation;
			}
			else if(parameterMethod.getType().equals(elementWithMetadata.getClass()))
			{
				args[cont] = elementWithMetadata;
			}
			else if(parameterMethod.getType().equals(container.getClass()))
			{
				args[cont] = container;

			}
			else if(parameterMethod.getType().equals(ContainerTarget.class) )
			{
				args[cont] = target;

			}
			cont++;
		}

		
		if(methodToInvoke.invoke(objectToInvoke, args)!=null){
			returnInvoke=methodToInvoke.invoke(objectToInvoke, args);
		}
	}

}
