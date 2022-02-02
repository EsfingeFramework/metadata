package net.sf.esfinge.metadata.locate;

import net.sf.esfinge.metadata.annotation.finder.SearchOnAbstractions;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Member;
import java.lang.reflect.Method;

//TODO Refatorar o locator para usar o locator.....
public class InheritanceLocator extends MetadataLocator {

	private AnnotatedElement originalElement;

	@Override
	public Annotation findMetadata(AnnotatedElement element, Class<? extends Annotation> annotationClass) throws MetadataLocationException {
		Annotation nextLocatorFound = getNextLocator().findMetadata(element, annotationClass);
		if(nextLocatorFound==null && annotationClass.isAnnotationPresent(SearchOnAbstractions.class)){
			if(element instanceof Class){
				Class clazz = (Class) element;

				Class superClazz = clazz.getSuperclass();

				Annotation annotation = null;
				if(superClazz != Object.class){
					annotation = findMetadata(superClazz,annotationClass);

				}
				Class[] interfaces = clazz.getInterfaces();
				for(Class ainterface : interfaces){

					annotation =  findMetadata(ainterface,annotationClass);
				}
				return annotation;
			}else if(element instanceof Method){
				Method method = (Method) element;
				Class clazz = method.getDeclaringClass();
				Class superClazz = clazz.getSuperclass();

				Annotation annotation = null;
				if(superClazz != Object.class){

					try {
						Method superMethod = superClazz.getMethod(method.getName(),method.getParameterTypes());
						annotation = findMetadata(superMethod,annotationClass);
					} catch (NoSuchMethodException e) {
						// continue if there is no method
					}

				}
				//procurar método nas interfaces
				Class[] interfaces = clazz.getInterfaces();
				for(Class ainterface : interfaces){

					try{

						Method methodOfInterface = ainterface.getMethod(method.getName(),method.getParameterTypes());

						annotation = findMetadata(methodOfInterface,annotationClass);
					}catch(NoSuchMethodException nsmex){
						//continue if there is no method...
					}
				}
				return annotation;
			}
		}

		return nextLocatorFound;
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
		boolean nextLocatorFound = getNextLocator().hasMetadata(element, annotationClass);
		if(!nextLocatorFound && annotationClass.isAnnotationPresent(SearchOnAbstractions.class)){
			if(element instanceof Class){
				Class clazz = (Class) element;

				Class superClazz = clazz.getSuperclass();

				boolean result = false;
				if(superClazz != Object.class){
					result = result || hasMetadata(superClazz,annotationClass);

				}
				Class[] interfaces = clazz.getInterfaces();
				for(Class ainterface : interfaces){

					result = result || hasMetadata(ainterface,annotationClass);
				}
				return result;
			}else if(element instanceof Method){
				Method method = (Method) element;
				Class clazz = method.getDeclaringClass();
				Class superClazz = clazz.getSuperclass();

				boolean result = false;
				if(superClazz != Object.class){

					try {
						Method superMethod = superClazz.getMethod(method.getName(),method.getParameterTypes());
						result = result || hasMetadata(superMethod,annotationClass);
					} catch (NoSuchMethodException e) {
						// continue if there is no method
					}

				}
				//procurar método nas interfaces
				Class[] interfaces = clazz.getInterfaces();
				for(Class ainterface : interfaces){

					try{

						Method methodOfInterface = ainterface.getMethod(method.getName(),method.getParameterTypes());

						result = result || hasMetadata(methodOfInterface,annotationClass);
					}catch(NoSuchMethodException nsmex){
						//continue if there is no method...
					}
				}
				return result;
			}
		}

		return nextLocatorFound;
	}

}
