
package net.sf.esfinge.metadata.locate;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;

public class EnclosingElementLocator extends MetadataLocator {
	
	private int contador=0;
	private AnnotatedElement OriginalElement;
	
	@Override
	public Annotation findMetadata(AnnotatedElement element, Class<? extends Annotation> annotationClass)
			throws MetadataLocationException {

		if(contador==0) OriginalElement = element;		
		
		contador++;
		
		Annotation an=null;		
		
		Annotation[] ans = element.getAnnotations();
		
		for (Annotation a : ans) {
			Class<?extends Annotation> c = a.annotationType();
			
				if(c.equals(annotationClass)){
					an = a;
					return an;					
					
				}else{
					InsideAnnotationLocator ll = new InsideAnnotationLocator();
					an = ll.findMetadata(c, annotationClass);

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
			} else if (element instanceof Class && ((Class) element).getPackage() != null) {
				return findMetadata(((Class) element).getPackage(),
						annotationClass);
			}
		}		
		return an;
	}
	
	@Override
	public boolean hasMetadata(AnnotatedElement element, Class<? extends Annotation> annotationClass) {

		boolean nextLocatorFound = getNextLocator().hasMetadata(element, annotationClass);
		if(!nextLocatorFound){
			if(element instanceof Method ||element instanceof Field ){
				Class clazz = ((Member) element).getDeclaringClass();

				for(Annotation an : clazz.getDeclaredAnnotations()){

					if(an.annotationType().isAssignableFrom(annotationClass)){
						return true;
					}
				}
			}
		}
		return nextLocatorFound;
	}

}
