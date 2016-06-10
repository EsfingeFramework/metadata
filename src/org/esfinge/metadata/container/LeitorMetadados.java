package org.esfinge.metadata.container;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.esfinge.metadata.AnnotationFinder;
import org.esfinge.metadata.TestAnottation.Tabela;
import org.esfinge.metadata.locate.MetadataLocator;
import org.esfinge.metadata.validate.MetadataValidator;

import static org.apache.commons.beanutils.PropertyUtils.*;

//import java.util.ArrayList;

public class LeitorMetadados {
	
	//To be modified as necessary. Currently only checks if BooleanAnnotation is present on methods.
	//TODO:Checking on classes and parameters
	

	public <E> E lerMetadadosDePara(Class<?> classWithMetadata, Class<E> containerClass) throws Exception {

		Object container = containerClass.newInstance();
				//Annotation field
		for (Field field: containerClass.getDeclaredFields())
		{
			if(field.isAnnotationPresent(ContainsAnnotation.class)){
				ContainsAnnotation annot = field.getAnnotation(ContainsAnnotation.class);
				Class<? extends Annotation> annotationThatNeedToContains = annot.value();
				setProperty(container,field.getName(), classWithMetadata.isAnnotationPresent(annotationThatNeedToContains));
				//field.set(container, classWithMetadata.isAnnotationPresent(annotationThatNeedToContains));
			}
			else if(field.isAnnotationPresent(ElementName.class))
			{
				setProperty(container,field.getName(),classWithMetadata.getName());
			}
			else if(field.isAnnotationPresent(ReflectionReference.class))
			{
				setProperty(container, field.getName(),classWithMetadata);
			}
			else if(field.isAnnotationPresent(AnnotationProperty.class))
			{
				AnnotationProperty annotP= field.getAnnotation(AnnotationProperty.class);
				
				Class<? extends Annotation> annotationThatNeedToContains = annotP.annotation();
				if (classWithMetadata.isAnnotationPresent(annotationThatNeedToContains)){
					
					Annotation annotation = classWithMetadata.getAnnotation(annotationThatNeedToContains);
					
					for(Method methodAnotation: annotation.annotationType().getDeclaredMethods()){
						if(methodAnotation.getName().equals(annotP.property())){
							setProperty(container, field.getName(),methodAnotation.invoke(annotation));
						}
							
					}
				}

			}
		}
		
		return (E) container;
	}	
	
}

