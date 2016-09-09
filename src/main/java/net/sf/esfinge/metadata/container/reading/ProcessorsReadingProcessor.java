package net.sf.esfinge.metadata.container.reading;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.sql.rowset.spi.TransactionalWriter;

import net.sf.esfinge.metadata.AnnotationFinder;
import net.sf.esfinge.metadata.AnnotationReader;
import net.sf.esfinge.metadata.AnnotationReadingException;
import net.sf.esfinge.metadata.AnnotationValidationException;
import net.sf.esfinge.metadata.annotation.container.Processors;
import net.sf.esfinge.metadata.container.AnnotationReadingProcessor;
import net.sf.esfinge.metadata.container.ContainerTarget;
import net.sf.esfinge.metadata.validate.MetadataValidator;

public class ProcessorsReadingProcessor implements AnnotationReadingProcessor{

	private Field fieldAnnoted;
	private Processors processors;
	private Class<? extends Annotation> processorsClass;
	ParameterizedType fieldGenericType;

	@Override
	public void initAnnotation(Annotation an, Field field) throws AnnotationValidationException {
		System.out.println("============init ProcessorsReadingProcessor============");
		fieldAnnoted = field;
		processors = (Processors)an;
		processorsClass = processors.value();
		fieldGenericType = (ParameterizedType) fieldAnnoted.getGenericType();
	}

	@Override
	public void read(AnnotatedElement classWithMetadata, Object container, ContainerTarget enumStr)
			throws AnnotationReadingException {
		try{
			System.out.println("============read ProcessorsReadingProcessor============");
			for (Annotation annotation : classWithMetadata.getAnnotations()) {
				for(Annotation annotationAnotation: annotation.annotationType().getAnnotations())
				{
					if(!annotationAnotation.annotationType().equals(Retention.class)){
						for(Method method: annotationAnotation.annotationType().getDeclaredMethods())
						{
							
							Class<?> selectClass = (Class<?>) method.invoke(annotationAnotation);
							for(Type args: fieldGenericType.getActualTypeArguments())
							{
								for (Type selectClassAType : selectClass.getGenericInterfaces()) {
									if(!args.equals(selectClassAType))
									{
										throw new AnnotationReadingException("O tipo esperado é "+args+"em vez disso foi passado "+ selectClassAType);
									}

								}
								
							}
							
						}
						
					}
				}
			}

		}
		catch (Exception e) {
			// TODO: handle exception
			throw new AnnotationReadingException(e);
		}
		
	}

}
