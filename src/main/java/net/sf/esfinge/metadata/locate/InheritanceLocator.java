package net.sf.esfinge.metadata.locate;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;

//TODO Refatorar o locator para usar o locator.....
public class InheritanceLocator extends MetadataLocator {

	private AnnotatedElement originalElement;

	@Override
	public Annotation findMetadata(AnnotatedElement element, Class<? extends Annotation> annotationClass)
			throws MetadataLocationException {
		
		originalElement = element;
		if(originalElement instanceof Class)
		{
			return forClassAnnotation(annotationClass);
			
		}
		else if(originalElement instanceof Method)
		{
			Method methodElement = (Method) originalElement;
			Class<?> classWithElement= methodElement.getDeclaringClass();
			//Implements methods in class
				for(Class<?> interfaceWithMethods: classWithElement.getInterfaces())
					{
						try {
							Method interfaceMethod = interfaceWithMethods.getMethod(methodElement.getName());
							if(interfaceMethod.isAnnotationPresent(annotationClass))
							{
								return interfaceMethod.getAnnotation(annotationClass);
							}
							
							
						} catch (NoSuchMethodException | SecurityException e) {
							e.printStackTrace();
						}
					}
				
			if(!classWithElement.isInterface())
			{
				while(!classWithElement.getSuperclass().equals(Object.class))
				{
					classWithElement = classWithElement.getSuperclass();
					Method superClassMethod;
					try {
						superClassMethod = classWithElement.getMethod(methodElement.getName());
						if(superClassMethod.isAnnotationPresent(annotationClass))
						{
							return superClassMethod.getAnnotation(annotationClass);
						}

					} catch (NoSuchMethodException | SecurityException e) {
						e.printStackTrace();
					}					
				}
				

			}
			
		}
		
		return null;
	}

	private Annotation forClassAnnotation(Class<? extends Annotation> annotationClass) {
		Class<?> classWithMetadata = (Class)originalElement;
		for ( Class<?> x : classWithMetadata.getInterfaces()) {
			if(x.isAnnotationPresent(annotationClass))
			{
				//TODO validate annotation in Interfaces
				return x.getAnnotation(annotationClass);
			}
		}
		if(!classWithMetadata.isInterface())
		{
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
