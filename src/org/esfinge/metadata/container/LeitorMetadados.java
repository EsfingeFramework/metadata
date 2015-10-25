package org.esfinge.metadata.container;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
//import java.util.ArrayList;

public class LeitorMetadados {
	
	//To be modified as necessary. Currently only checks if BooleanAnnotation is present on methods.
	//TODO:Checking on classes and parameters
	

	public <E> E lerMetadadosDePara(Class<?> classWithMetadata, Class<E> containerClass) throws Exception {
		
		Object container = containerClass.newInstance();
		Class<? extends Annotation> targetAnnotation = null;
		
		if(classWithMetadata.isAnnotationPresent(AnnotationAttribute.class))
		{
			AnnotationAttribute an = classWithMetadata.getAnnotation(AnnotationAttribute.class);
			targetAnnotation = an.annotation();
		}
		
		try{
			if(classWithMetadata.isAnnotationPresent(targetAnnotation))
			{
				//Adding to container?
			}
			for(Method m:classWithMetadata.getMethods())
			{
				if(m.isAnnotationPresent(targetAnnotation))
				{
					//adding to container?
				}
			}
		}catch(Exception e){
			throw new RuntimeException("Erro recuperando propriedade", e);
		}
		
		return (E) container;
	}
}
