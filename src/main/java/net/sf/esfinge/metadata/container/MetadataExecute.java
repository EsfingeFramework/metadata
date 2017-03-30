package net.sf.esfinge.metadata.container;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.hamcrest.core.IsInstanceOf;

import net.sf.esfinge.metadata.AnnotationFinder;
import net.sf.esfinge.metadata.AnnotationReader;
import net.sf.esfinge.metadata.AnnotationValidationException;
import net.sf.esfinge.metadata.annotation.container.AnnotationReadingConfig;
import net.sf.esfinge.metadata.annotation.container.ContainerFor;
import net.sf.esfinge.metadata.validate.MetadataValidator;

public class MetadataExecute {

	AnnotationReadingConfig arc;
	AnnotationReadingProcessor processor;
	Class<?> containerClass;
	ContainerFor containerFor;
	public MetadataExecute(Class<?> containerClass) throws AnnotationValidationException {
		this.containerClass = containerClass;
		
		this.containerFor = this.containerClass.getDeclaredAnnotation(ContainerFor.class);
		if(containerFor == null)
		{
			throw new AnnotationValidationException("The annotation ContainerFor is null in the container ");
		}
		
		MetadataValidator.validateMetadataOn(this.containerClass);
	}

	public Object execMetadata(Map<AnnotatedElement,Annotation> repositorio, AnnotatedElement elementWithMetadata)
			throws Exception {
		Object container;
		container = this.containerClass.newInstance();
		
		
		
		if((container instanceof MetadataContainer)||(container instanceof FieldMetadataContainer))
		{
			System.out.println(repositorio.size());
			Set<AnnotatedElement> reg = repositorio.keySet();
			for (Iterator<AnnotatedElement> iterator = reg.iterator(); iterator.hasNext();) {
				AnnotatedElement element= iterator.next();
				Annotation chave = repositorio.get(element);
				Annotation an = chave;
				Class<?> annotationClass = an.annotationType();
				
				if (AnnotationFinder.existAnnotation(annotationClass, AnnotationReadingConfig.class)) {
					arc = annotationClass.getAnnotation(AnnotationReadingConfig.class);
					processor = arc.value().newInstance();
					processor.initAnnotation(an, (Field) element);
					processor.read(elementWithMetadata, container, containerFor.value());
				}
			}
			
		}
		else
		{
			AnnotationReader ar = new AnnotationReader();
									
			MetadataContainer containerMetadata = ar.readingAnnotationsTo(containerClass, MetadataContainer.class);
			
			System.out.println("\n"+container+"\n");
			
			for( FieldMetadataContainer fieldsContainer :containerMetadata.getFields()){
				Map<Field, AnnotationReadingProcessor> processFields = fieldsContainer.getProcessors();
				
				Iterator it = processFields.values().iterator();
				while (it.hasNext()) {
					AnnotationReadingProcessor reading = (AnnotationReadingProcessor)it.next();
					reading.read(elementWithMetadata, container, containerFor.value());
				}
				
			}
			
		}
		
		return container;
	}

}