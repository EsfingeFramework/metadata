package org.esfinge.metadata.container;

import java.lang.reflect.Method;
//import java.util.ArrayList;

public class LeitorMetadados {
	
	//To be modified as necessary. Currently only checks if BooleanAnnotation is present on methods.
	//TODO:Checking on classes and parameters (not done because I'm unsure if different containers will be used)
	
	public ContainerMetadados lerMetadados(Class<?> classToMap){
		
		ContainerMetadados container = new ContainerMetadados();
	
		
		//ArrayList<Annotation> annotationsToCheck = new ArrayList<Annotation>();
		//populating annotationsToCheck (specific to each case? Missing function?)
		//Something like:
		// annotationsToCheck = AnnotationFinder.findAnnotations(classToMap.class);

		
		for(Method m:classToMap.getMethods())
		{
			try
			{
				if(m.isAnnotationPresent(BooleanAnnotation.class))
				{
					Properties p = new Properties(m);
					p.setHasAnnotation(true);
					System.out.println(p.getName());
					container.addPropriedade(p);
				}
			}catch (Exception e){
				throw new RuntimeException("Erro recuperando propriedade", e);
			}
		}
		
		return container;
	}
}
