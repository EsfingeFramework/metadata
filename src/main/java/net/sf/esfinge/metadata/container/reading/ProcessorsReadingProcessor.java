package net.sf.esfinge.metadata.container.reading;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

import net.sf.esfinge.containerProcessosrsTest.Algo;
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

	@Override
	public void initAnnotation(Annotation an, Field field) throws AnnotationValidationException {
		fieldAnnoted = field;
		processors = (Processors)an;
		processorsClass = processors.value();
	}

	@Override
	public void read(AnnotatedElement classWithMetadata, Object container, ContainerTarget enumStr)
			throws AnnotationReadingException {
		try{
			List<Annotation> elementAnnoted = AnnotationFinder.findAnnotation(classWithMetadata, processorsClass);
			for(Annotation ann: elementAnnoted){
				for(Method method: ann.annotationType().getDeclaredMethods()){
					Class<?> clazz =(Class<?>)method.invoke(ann);
					System.out.println(clazz);
					for(Method m1 : clazz.getDeclaredMethods())
					{
						AnnotationReader reader = new AnnotationReader();
						//Class containerr = reader.readingAnnotationsTo(m1, Class.class);
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
