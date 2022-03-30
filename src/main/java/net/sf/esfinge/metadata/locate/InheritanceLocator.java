package net.sf.esfinge.metadata.locate;

import net.sf.esfinge.metadata.annotation.finder.SearchOnAbstractions;
import net.sf.esfinge.metadata.annotation.finder.SearchOnEnclosingElements;
import net.sf.esfinge.metadata.utils.AnnotatedElementUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.List;


public class InheritanceLocator extends MetadataLocator {

	private AnnotatedElement originalElement;

	@Override
	public List<Annotation> findAllMetadata(AnnotatedElement element) throws MetadataLocationException {
		List<Annotation> annotations = nextLocator.findAllMetadata(element);
		if(annotations==null){
			if(element instanceof Class){
				Class clazz = (Class) element;
				Class superClazz = clazz.getSuperclass();
				if(superClazz!= Object.class && superClazz!=null){
					List<Annotation> superClazzAnnotations = findAllMetadata(superClazz);
					for(Annotation a: superClazzAnnotations){
						if(a.annotationType().isAnnotationPresent(SearchOnEnclosingElements.class)) {
							AnnotatedElementUtils.addAnnotationIfNotInList(a, annotations);
						}
					}
				}
				Class[] interfaces = clazz.getInterfaces();
				for(Class ainterface : interfaces){
					List<Annotation> ClazzInterfaceAnnotations = findAllMetadata(ainterface);
					for(Annotation a : ClazzInterfaceAnnotations){
						if(a.annotationType().isAnnotationPresent(SearchOnEnclosingElements.class)) {
							AnnotatedElementUtils.addAnnotationIfNotInList(a, annotations);
						}
					}
				}
				return annotations;
			}else if(element instanceof Method){
				Method method = (Method) element;
				Class clazz = method.getDeclaringClass();
				Class superClazz = clazz.getSuperclass();
				if(superClazz!=Object.class && superClazz!=null){
					try {
						Method superMethod = superClazz.getMethod(method.getName(),method.getParameterTypes());
						List<Annotation> superMethodAnnotations = findAllMetadata(superMethod);
						for(Annotation a : superMethodAnnotations){
							if(a.annotationType().isAnnotationPresent(SearchOnEnclosingElements.class)) {
								AnnotatedElementUtils.addAnnotationIfNotInList(a, annotations);
							}
						}
					} catch (NoSuchMethodException e) {
						// continue if there is no method
					}
					Class[] methodInterfaces = clazz.getInterfaces();
					for(Class ainterface : methodInterfaces){
						try {
							Method methodOfInterface = ainterface.getMethod(method.getName(),method.getParameterTypes());
							List<Annotation> methodOfInterfaceAnnotations = findAllMetadata(methodOfInterface);
							for(Annotation a : methodOfInterfaceAnnotations){
								if(a.annotationType().isAnnotationPresent(SearchOnEnclosingElements.class)) {
									AnnotatedElementUtils.addAnnotationIfNotInList(a, annotations);
								}
							}
						} catch (NoSuchMethodException e) {
							e.printStackTrace();
						}
					}
				}
				return annotations;
			}
		}

		return annotations;
	}

	@Override
	public Annotation findMetadata(AnnotatedElement element, Class<? extends Annotation> annotationClass) throws MetadataLocationException {
		Annotation nextLocatorFound = getNextLocator().findMetadata(element, annotationClass);
		if(nextLocatorFound==null && annotationClass.isAnnotationPresent(SearchOnAbstractions.class)){
			if(element instanceof Class){
				Class clazz = (Class) element;
				Class superClazz = clazz.getSuperclass();
				Annotation annotation = null;
				if(superClazz != Object.class && superClazz!=null){
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
				if(superClazz != Object.class && superClazz!=null){

					try {
						Method superMethod = superClazz.getMethod(method.getName(),method.getParameterTypes());
						annotation = findMetadata(superMethod,annotationClass);
					} catch (NoSuchMethodException e) {
						// continue if there is no method
					}

				}
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
				if(superClazz != Object.class && superClazz!=null){
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
				if(superClazz != Object.class && superClazz!=null){

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
