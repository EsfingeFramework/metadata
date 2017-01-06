package net.sf.esfinge.metadata.locate;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.AnnotatedType;

public class InheritanceLocator extends MetadataLocator {

	private int contador = 0;
	private AnnotatedElement originalElement;

	@Override
	public Annotation findMetadata(AnnotatedElement element, Class<? extends Annotation> annotationClass)
			throws MetadataLocationException {
		
		originalElement = element;
		if(originalElement instanceof Class)
		{
			Class classWithMetadata = (Class)originalElement;
			for ( Class x : classWithMetadata.getInterfaces()) {
				if(x.isAnnotationPresent(annotationClass))
				{
					//TODO validate annotation in Interfaces
					return x.getAnnotation(annotationClass);
				}
			}
			while(!classWithMetadata.getSuperclass().equals(Object.class))
			{
				classWithMetadata = classWithMetadata.getSuperclass();
				if(classWithMetadata.isAnnotationPresent(annotationClass))
				{
					//TODO validate annotation in superclass
					return classWithMetadata.getAnnotation(annotationClass);
				}
			}
			
		}
		
		return null;
	}

	@Override
	public boolean hasMetadata(AnnotatedElement element, Class<? extends Annotation> annotationClass) {
		return false;
	}

}
