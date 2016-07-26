package org.esfinge.metadata.container;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.esfinge.metadata.AnnotationValidationException;
import org.esfinge.metadata.annotation.container.AnnotationReadingConfig;
import org.esfinge.metadata.annotation.container.ContainerFor;
import org.esfinge.metadata.validate.MetadataValidator;

public class MetadataExecute {

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
		
		Set<AnnotatedElement> reg = repositorio.keySet();
		for (Iterator<AnnotatedElement> iterator = reg.iterator(); iterator.hasNext();) {
			AnnotatedElement element= iterator.next();
			Annotation chave = repositorio.get(element);
			Annotation an = chave;
			Class<?> annotationClass = an.annotationType();
			if (annotationClass.isAnnotationPresent(AnnotationReadingConfig.class)) {
				AnnotationReadingConfig arc = annotationClass.getAnnotation(AnnotationReadingConfig.class);
				AnnotationReadingProcessor processor = arc.value().newInstance();
				processor.initAnnotation(an, (Field) element);
				processor.read(elementWithMetadata, container, containerFor.vaule());
			}
		}
		return container;
	}

}
