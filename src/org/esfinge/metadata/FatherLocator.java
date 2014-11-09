package org.esfinge.metadata;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class FatherLocator implements MetadataLocator {

	@Override
	public Annotation findMetadata(AnnotatedElement element, Class<? extends Annotation> annotationClass) throws MetadataLocationException {
		
		Annotation an = element.getAnnotation(annotationClass);
		
		if (an == null) {			
			if (element instanceof Method) {
				System.out.println("method");
				return findMetadata(((Method) element).getDeclaringClass(), annotationClass);
			} else if (element instanceof Field) {
				System.out.println("field");
				return findMetadata(((Field) element).getDeclaringClass(), annotationClass);
			} else if (element instanceof Class) {
				System.out.println("class");
				return findMetadata(((Class) element).getPackage(), annotationClass);
			}
		}
		return an;
	}

	@Override
	public boolean hasMetadata(AnnotatedElement element, Class<? extends Annotation> annotationClass) {
		// TODO Auto-generated method stub
		return false;
	}

}
