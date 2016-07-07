package org.esfinge.metadata.container;

import java.awt.Container;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.esfinge.metadata.AnnotationFinder;
import org.esfinge.metadata.AnnotationReadingException;
import org.esfinge.metadata.AnnotationValidator;
import org.esfinge.metadata.annotation.container.AnnotationReadingConfig;
import org.esfinge.metadata.annotation.container.ContainerFor;
import org.esfinge.metadata.validate.ValidFieldTypeValidator;

public class MetadataExecute {

	Class<?> containerClass;

	public MetadataExecute(Class<?> containerClass) {
		this.containerClass = containerClass;

	}

	public Object execMetadata(Map<Annotation, AnnotatedElement> repositorio, AnnotatedElement elementWithMetadata)
			throws Exception {
		// TODO Auto-generated method stub
		Object container;
		container = this.containerClass.newInstance();
		ContainerFor containerFor = (ContainerFor) containerClass.getDeclaredAnnotation(ContainerFor.class);
		
		/*ENUMMM
		System.out.println(containerFor.vaule());
		*/
		
		Set<Annotation> reg = repositorio.keySet();
		for (Iterator<Annotation> iterator = reg.iterator(); iterator.hasNext();) {
			Annotation chave = iterator.next();
			AnnotatedElement element = repositorio.get(chave);
			Annotation an = chave;
			Class<?> annotationClass = an.annotationType();
			AnnotationValidator vf1 = new ValidFieldTypeValidator();
			vf1.validate(chave, element);
			if (annotationClass.isAnnotationPresent(AnnotationReadingConfig.class)) {
				AnnotationReadingConfig arc = annotationClass.getAnnotation(AnnotationReadingConfig.class);
				AnnotationReadingProcessor processor = arc.value().newInstance();
				processor.initAnnotation(an, (Field) element);
				processor.read(elementWithMetadata, container);
			}
		}
		return container;
	}

}
