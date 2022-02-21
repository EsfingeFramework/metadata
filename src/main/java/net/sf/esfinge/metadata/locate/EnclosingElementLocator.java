
package net.sf.esfinge.metadata.locate;

import net.sf.esfinge.metadata.annotation.finder.SearchOnEnclosingElements;
import net.sf.esfinge.metadata.utils.AnnotatedElementUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class EnclosingElementLocator extends MetadataLocator {
	
	private int contador=0;
	private AnnotatedElement OriginalElement;

	@Override
	public List<Annotation> findAllMetadata(AnnotatedElement element) throws MetadataLocationException {
		StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
		for(StackTraceElement e : stackTraceElements)
			System.out.println(e.getMethodName());
		List<Annotation> annotations;
		System.out.println(((Class<?>) element).getName()+" here?");
		annotations = nextLocator.findAllMetadata(element);
		if(element instanceof Method || element instanceof Field ){
			Class clazz = ((Member) element).getDeclaringClass();
			for(Annotation a : clazz.getDeclaredAnnotations()){
				if(a.annotationType().isAnnotationPresent(SearchOnEnclosingElements.class)){
					AnnotatedElementUtils.addAnnotationIfNotInList(a,annotations);
				}
			}

		}else if (element instanceof Class){
			System.out.println(((Class<?>) element).getName()+" here?");
			Package apackage = ((Class) element).getPackage();
			for(Annotation a : apackage.getDeclaredAnnotations()){
				if(a.annotationType().isAnnotationPresent(SearchOnEnclosingElements.class)){
					AnnotatedElementUtils.addAnnotationIfNotInList(a,annotations);
				}
			}
		}
		return annotations;
	}

	@Override
	public Annotation findMetadata(AnnotatedElement element, Class<? extends Annotation> annotationClass) throws MetadataLocationException {
		Annotation nextLocatorFound = getNextLocator().findMetadata(element, annotationClass);

		if(nextLocatorFound==null && annotationClass.isAnnotationPresent(SearchOnEnclosingElements.class)){

			if(element instanceof Method || element instanceof Field ){
				Class clazz = ((Member) element).getDeclaringClass();
				return findMetadata(clazz,annotationClass);
			}else if (element instanceof Class){

				Package apackage = ((Class) element).getPackage();

				return findMetadata(apackage,annotationClass);
			}
		}
		return nextLocatorFound;
	}

	
	@Override
	public boolean hasMetadata(AnnotatedElement element, Class<? extends Annotation> annotationClass) {
		boolean nextLocatorFound = getNextLocator().hasMetadata(element, annotationClass);

		if(!nextLocatorFound && annotationClass.isAnnotationPresent(SearchOnEnclosingElements.class)){

			if(element instanceof Method || element instanceof Field ){
				Class clazz = ((Member) element).getDeclaringClass();
				return hasMetadata(clazz,annotationClass);
			}else if (element instanceof Class){

				Package apackage = ((Class) element).getPackage();

				return hasMetadata(apackage,annotationClass);
			}
		}
		return nextLocatorFound;
	}

}
