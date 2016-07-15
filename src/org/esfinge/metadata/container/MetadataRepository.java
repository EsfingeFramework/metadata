package org.esfinge.metadata.container;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MetadataRepository {
	private Map<Annotation,AnnotatedElement> repositorio;
	
	public void findMetadata(Class<?> containerClass)
	{
		repositorio = new HashMap<Annotation,AnnotatedElement>();			
		for (Field field : containerClass.getDeclaredFields())
		{
			Annotation[] annotationsField =field.getDeclaredAnnotations();
			
			for(Annotation annot: annotationsField)
			{
				repositorio.put(annot,(AnnotatedElement)field);
			}
		}
	}

	public Map<Annotation,AnnotatedElement> getRepositorio() {
		return repositorio;
	}

	public void setRepositorio(Map<Annotation,AnnotatedElement> repositorio) {
		this.repositorio = repositorio;
	}
	
}
