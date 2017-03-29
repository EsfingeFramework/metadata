package net.sf.esfinge.metadata.container;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class MetadataRepository {
	private Map<AnnotatedElement,Annotation> repositorio;
	
	
	
	@Override
	public String toString() {
		return "MetadataRepository [repositorio=" + repositorio.toString() + "]";
	}

	public void findMetadata(Class<?> containerClass)
	{
		repositorio = new HashMap<AnnotatedElement,Annotation>();			
		for (Field field : containerClass.getDeclaredFields())
		{
			Annotation[] annotationsField =field.getDeclaredAnnotations();
			
			for(Annotation annot: annotationsField)
			{
				repositorio.put((AnnotatedElement)field,annot);
			}
		}
	}

	public Map<AnnotatedElement, Annotation> getRepositorio() {
		return repositorio;
	}

	public void setRepositorio(Map<AnnotatedElement, Annotation> repositorio) {
		this.repositorio = repositorio;
	}
	
}