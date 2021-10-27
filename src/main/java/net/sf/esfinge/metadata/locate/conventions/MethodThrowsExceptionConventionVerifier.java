package net.sf.esfinge.metadata.locate.conventions;


import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;

import net.sf.esfinge.metadata.locate.conventions.annotations.MethodThrowsExceptionConvention;
public class MethodThrowsExceptionConventionVerifier implements ConventionVerifier<MethodThrowsExceptionConvention>{
	
	private Class<?> exceptionType;

	@Override
	public void init(MethodThrowsExceptionConvention conventionAnnotation) {

		exceptionType = conventionAnnotation.thrownException();
	}

	@Override
	public boolean isConventionPresent(AnnotatedElement element) {
		if(element instanceof Method){
			Class<?>[] declaredExceptions = ((Method) element).getExceptionTypes();

			for(Class e : declaredExceptions){
				if(exceptionType.equals(e)){
					return true;					
				}
			}

		}
		return false;
	}
}
