package net.sf.esfinge.metadata.container;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import net.sf.esfinge.metadata.AnnotationReadingException;

public class MetadataRepository {
	
	private Map<Class<?>,Map<AnnotatedElement, Object>> repository = new HashMap<>();
	
	private void addContainer(Class<?> containerClass, AnnotatedElement targetElement, Object container) throws AnnotationReadingException{
		if(!containerClass.isInstance(container)){
			throw new AnnotationReadingException("The container is not from the container class");
		}
		if(!repository.containsKey(containerClass)){
			repository.put(containerClass, new HashMap<>());
		}
		repository.get(containerClass).put(targetElement, container);
	}
	
	public <E> E getContainer(Class<E> containerClass, AnnotatedElement targetElement) throws AnnotationReadingException{
		if(repository.containsKey(containerClass) && repository.get(containerClass).containsKey(targetElement)){
			return (E) repository.get(containerClass).get(targetElement);
		}else{
			Object newContainer = null; //ler o metadado
			addContainer(containerClass, targetElement, newContainer);
			return (E) newContainer;
		}
	}
	
	
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