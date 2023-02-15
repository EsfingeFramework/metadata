package net.sf.esfinge.metadata.container.reading;

import static org.apache.commons.beanutils.PropertyUtils.setProperty;

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
import net.sf.esfinge.metadata.annotation.container.PropertyProcessors;
import net.sf.esfinge.metadata.container.AnnotationReadingProcessor;
import net.sf.esfinge.metadata.container.ContainerTarget;
import net.sf.esfinge.metadata.factory.LocatorsFactory;
import net.sf.esfinge.metadata.locate.MetadataLocator;
import net.sf.esfinge.metadata.utils.AnnotatedElementUtils;

public class PropertyProcessorsReadingProcessor implements AnnotationReadingProcessor{

	private Field fieldAnnoted;
	private List<Object> list;
	private PropertyProcessors processors;
	private Class<? extends Annotation> processorsAnnotationClass;
	Type fieldGenericType;
	private Object returnInvoke;

	@Override
	public void initAnnotation(Annotation an, AnnotatedElement elementWithMetadata) throws AnnotationValidationException {
		
		
		fieldAnnoted = (Field) elementWithMetadata;

		processors = (PropertyProcessors)an;
		processorsAnnotationClass = processors.value();
		fieldGenericType =  fieldAnnoted.getGenericType();
		list = new ArrayList<Object>();				
	}

	@Override
	public void read(AnnotatedElement elementWithMetadata, Object container, ContainerTarget target)
			throws AnnotationReadingException {
		try{			
			annotationSearch(elementWithMetadata, container);

			setProperty(container,fieldAnnoted.getName(),list);
		}
		catch (Exception e) {
			// TODO: handle exception
			throw new AnnotationReadingException(e);
		}
		
	}

	private void annotationSearch(AnnotatedElement elementWithMetadata, Object container)
			throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException, AnnotationReadingException {
		if((elementWithMetadata.getClass().equals(Field.class)) && (elementWithMetadata.getAnnotations().length>0))
		{
			addObject(elementWithMetadata, container);
		}
		else
		{
			//Criar Um enum
			//Verificar qual o valor do enun
			//Executar os dados que foi passado pelo enum
			Field field = (Field) elementWithMetadata;
			Class<?> clazz = field.getDeclaringClass();
			Method method;
			
			if(field.getType().equals(boolean.class)||field.getType().equals(Boolean.class))
				method = clazz.getMethod(propertyToGetter(field.getName(),true));
			else
				method = clazz.getMethod(propertyToGetter(field.getName(),false));
			
			addObject(method, container);
		}
	}

	private void addObject(AnnotatedElement elementWithMetadata, Object container)
			throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException, AnnotationReadingException {
		MetadataLocator locator = LocatorsFactory.createLocatorsChain();

		for (Annotation annotation : locator.findAllMetadata(elementWithMetadata)) {
			//System.out.println(AnnotationFinder.existAnnotation(annotation.annotationType(), processorsAnnotationClass));
			//TODO Verificar essa parte Até
			if(AnnotationFinder.existAnnotation(annotation.annotationType(), processorsAnnotationClass)){
				//System.out.println(AnnotatedElementUtils.getName(elementWithMetadata));
				Annotation processorAnnotation = annotation.annotationType().getAnnotation(processorsAnnotationClass);
				Class<?> valueClass = (Class<?>) processorAnnotation.getClass().getDeclaredMethod("value").invoke(processorAnnotation);
				Object objectToInvoke = valueClass.newInstance();
				findDeclaredAnnotationOnInterface(elementWithMetadata, container, annotation, valueClass,
						objectToInvoke);
				
				if(processors.type() == ProcessorType.READER_IS_PROCESSOR){
					list.add(objectToInvoke);
				}
				else if(processors.type() == ProcessorType.READER_RETURNS_PROCESSOR){
					list.add(returnInvoke);
				}

				//list.add(objectToInvoke);
			}
			//AQUIIIIIII
		}
	}

	private void findDeclaredAnnotationOnInterface(AnnotatedElement elementWithMetadata, Object container,
			Annotation annotation, Class<?> valueClass, Object objectToInvoke)
			throws IllegalAccessException, InvocationTargetException, AnnotationReadingException {
		for(Class<?> interfaces : valueClass.getInterfaces())
		{
			for(Method methodToInvoke: interfaces.getDeclaredMethods())
			{
				//Retorna um array list com os metodos anotados com o @InitProcessor
				if(AnnotationFinder.existAnnotation(methodToInvoke, ExecuteProcessor.class))
				{
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
			else if(parameterMethod.getType().equals(AnnotatedElement.class))
			{
				args[cont] = elementWithMetadata;
			}
			else if(parameterMethod.getType().equals(container.getClass()))
			{
				args[cont] = container;

			}
			
			cont++;
		}
		if(methodToInvoke.invoke(objectToInvoke, args)!=null)
		{
			returnInvoke=methodToInvoke.invoke(objectToInvoke, args);			
		}
	}

    public static String propertyToGetter(String propertieName) {
		return propertyToGetter(propertieName, false);
	}
    
    public static String propertyToGetter(String propertieName, boolean isBoolean) {
		if(isBoolean)
			return "is"+propertieName.substring(0,1).toUpperCase()+propertieName.substring(1);
		return "get"+propertieName.substring(0,1).toUpperCase()+propertieName.substring(1);
	}

	
}
