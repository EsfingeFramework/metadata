package net.sf.esfinge.metadata.container;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import javax.security.auth.login.Configuration;

import net.sf.esfinge.metadata.AnnotationReadingException;
import net.sf.esfinge.metadata.AnnotationValidationException;

public class MetadataRepository {
	private static MetadataRepository instance;
	
	private Map<Class<?>,Map<AnnotatedElement, Object>> repository = new HashMap<>();
	
	public static void destroy()
	{
			 instance = null ;
		
	}
	
	public static MetadataRepository initializeRepository()
	{
		if ( instance == null ) {
			 instance = new MetadataRepository () ;
			}
		return instance;
	}
	
	
	private void addContainer(Class<?> containerClass, AnnotatedElement targetElement, Object container) throws AnnotationReadingException{
		if(!containerClass.isInstance(container)){
			throw new AnnotationReadingException("The container is not from the container class");
		}
		if(!repository.containsKey(containerClass)){
			repository.put(containerClass, new HashMap<>());
		}
		repository.get(containerClass).put(targetElement, container);
	}
	
	public <E> E getContainer(Class<E> containerClass, AnnotatedElement targetElement) throws Exception{
		if(repository.containsKey(containerClass) && repository.get(containerClass).containsKey(targetElement)){
			return (E) repository.get(containerClass).get(targetElement);
		}else{
			MetadataExecute execute = new MetadataExecute(containerClass);
			Object newContainer = null; //ler o metadado

			newContainer = execute.execMetadata(targetElement);
			addContainer(containerClass, targetElement, newContainer);
			return (E) newContainer;
		}
	}
	
	@Override
	public String toString() {
		return "MetadataRepository [repository=" + repository.toString() + "]";
	}

	
	
}