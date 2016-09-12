package net.sf.esfinge.metadata.container.reading;

import static org.apache.commons.beanutils.PropertyUtils.setProperty;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.esfinge.metadata.AnnotationReadingException;
import net.sf.esfinge.metadata.AnnotationValidationException;
import net.sf.esfinge.metadata.annotation.container.InitProcessor;
import net.sf.esfinge.metadata.annotation.container.MethodProcessors;
import net.sf.esfinge.metadata.annotation.container.Processors;
import net.sf.esfinge.metadata.container.AnnotationReadingProcessor;
import net.sf.esfinge.metadata.container.ContainerTarget;

public class MethodProcessorsReadingProcessor implements AnnotationReadingProcessor {

	private Field fieldAnnoted;
	private Map<Object,Object> map;
	private MethodProcessors processors;
	private Class<? extends Annotation> processorsAnnotationClass;
	ParameterizedType fieldGenericType;
	
	@Override
	public void initAnnotation(Annotation an, Field field) throws AnnotationValidationException {
		// TODO Auto-generated method stub
		fieldAnnoted = field;
		processors = (MethodProcessors)an;
		processorsAnnotationClass = processors.value();
		fieldGenericType = (ParameterizedType) fieldAnnoted.getGenericType();
		map = new HashMap<>();
	}

	@Override
	public void read(AnnotatedElement elementWithMetadata, Object container, ContainerTarget target)
			throws AnnotationReadingException {
		// TODO Auto-generated method stub
		try {
			if(elementWithMetadata instanceof Class)
			{
				Class clazz = (Class) elementWithMetadata;
				for(Method methodOfClazz : clazz.getDeclaredMethods())
				{
					for(Annotation annotation:methodOfClazz.getDeclaredAnnotations())
					{
						Annotation processorAnnotation = annotation.annotationType().getAnnotation(processorsAnnotationClass);
						//pega o class do value dessa anotation
						Class<?> valueClass = (Class<?>) processorAnnotation.getClass().getDeclaredMethod("value").invoke(processorAnnotation);
						//cria um objeto dessa classe e invoca o @InitProcessor
						Object objectToInvoke = valueClass.newInstance();
						for(Method methodToInvoke: valueClass.getInterfaces()[0].getDeclaredMethods())
						{
							if(methodToInvoke.isAnnotationPresent(InitProcessor.class)){
								Object[] args = new Object[methodToInvoke.getParameters().length];
								int cont = 0;
								for(Parameter p1 : methodToInvoke.getParameters()){
									if(p1.getType().equals(Annotation.class))
									{
										args[cont] = annotation;
									}
									else if(p1.getType().equals(AnnotatedElement.class))
									{
										args[cont] = elementWithMetadata;
									}
									else if(p1.getType().equals(container.getClass()))
									{
										args[cont] = container;
									}
									cont++;
								}
								methodToInvoke.invoke(objectToInvoke, args);
							}
						}					
						map.put(methodOfClazz, objectToInvoke);	

					}
				}
			}
			setProperty(container,fieldAnnoted.getName(),map);
		} catch (Exception e) {
			// TODO: handle exception
			throw new AnnotationReadingException("==========="+e);
		}
		
	}

}
