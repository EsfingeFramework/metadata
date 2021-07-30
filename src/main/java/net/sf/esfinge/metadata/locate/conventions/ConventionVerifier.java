package net.sf.esfinge.metadata.locate.conventions;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;

public interface ConventionVerifier<A extends Annotation> {
	
	public void init(A conventionAnnotation);
	
	//to init from external file
	//public void init(Map<String,String> parameters);
	
	public boolean isConventionPresent(AnnotatedElement element);


}
