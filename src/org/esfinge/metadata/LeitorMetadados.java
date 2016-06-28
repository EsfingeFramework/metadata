package org.esfinge.metadata;

import java.lang.annotation.Annotation;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.esfinge.metadata.AnnotationFinder.findAnnotation;
import org.esfinge.metadata.TestAnottation.Tabela;
import org.esfinge.metadata.container.AnnotationProperty;
import org.esfinge.metadata.container.AnnotationReadingConfig;
import org.esfinge.metadata.container.AnnotationReadingProcessor;
import org.esfinge.metadata.container.ContainerMetadados;
import org.esfinge.metadata.container.ContainsAnnotation;
import org.esfinge.metadata.container.ElementName;
import org.esfinge.metadata.container.ProcessFields;
import org.esfinge.metadata.container.ProcessMethods;
import org.esfinge.metadata.container.ReflectionReference;
import org.esfinge.metadata.locate.AnnotationLocator;
import org.esfinge.metadata.locate.MetadataLocator;
import org.esfinge.metadata.locate.RegularLocator;
import org.esfinge.metadata.validate.MetadataValidator;

import static org.apache.commons.beanutils.PropertyUtils.*;
import static org.esfinge.metadata.AnnotationFinder.findAnnotation;
//import java.util.ArrayList;

public class LeitorMetadados {

	// To be modified as necessary. Currently only checks if BooleanAnnotation
	// is present on methods.
	// TODO:Checking on classes and parameters

	public <E> E metadataReader(AnnotatedElement elementWithMetadata, Class<E> containerClass) throws Exception {

		Object container = containerClass.newInstance();

		for (Field field : containerClass.getDeclaredFields()) {
			
			boolean annot ;
			annot = AnnotationFinder.existAnnotation(field, ContainsAnnotation.class);
			System.out.println(annot);
			
			for (Annotation an : field.getAnnotations()) {
				Class<?> annotationClass = an.annotationType();
				if (AnnotationFinder.existAnnotation(annotationClass, AnnotationReadingConfig.class))
				//if (annotationClass.isAnnotationPresent(AnnotationReadingConfig.class)) 
				{
					AnnotationReadingConfig arc = annotationClass.getAnnotation(AnnotationReadingConfig.class);
					AnnotationReadingProcessor processor = arc.value().newInstance();
					processor.initAnnotation(an, field);
					processor.read(elementWithMetadata, container);
				}
			}
		}

		return (E) container;
	}

}
