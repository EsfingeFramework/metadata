package org.esfinge.metadata.locate;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.esfinge.metadata.validate.needsToHave.SearchInsideAnnotations;
import org.esfinge.metadata.validate.needsToHave.SearchOnEnclosingElements;

public class LevelLocator extends MetadataLocator {

	@Override
	public Annotation findMetadata(AnnotatedElement element, Class<? extends Annotation> annotationClass)
			throws MetadataLocationException {
		
		Annotation an=null;		
		
		Annotation[] ans = element.getAnnotations();
		
		for (Annotation a : ans) {			
			Class<?> c = a.annotationType();			
			if(c.equals(annotationClass)){					
				if (SearchOnEnclosingElements(c)) {
					System.out.println("subiu");
					return an = a;
				}
			}
							
		}	
		
		//Button-up Searching 
		if(ans.length <= 0 || an==null) {
			if (element instanceof Method) {
				return findMetadata(((Method) element).getDeclaringClass(),
						annotationClass);
			} else if (element instanceof Field) {
				return findMetadata(((Field) element).getDeclaringClass(),
						annotationClass);
			} else if (element instanceof Class) {
				return findMetadata(((Class) element).getPackage(),
						annotationClass);
			}
		}		
		
		an = nextLocator.findMetadata(element, annotationClass);
		return an;
	}
	
	//if true, Button-up searching
	public static boolean SearchOnEnclosingElements(Class<?> c) {
		return c.isAnnotationPresent(SearchOnEnclosingElements.class);
	}

	@Override
	public boolean hasMetadata(AnnotatedElement element,
			Class<? extends Annotation> annotationClass) {
		return false;
	}

}
