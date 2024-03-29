package net.sf.esfinge.metadata.locate.conventions;

import net.sf.esfinge.metadata.annotation.container.ExecuteProcessor;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.util.Map;

public interface ConventionVerifier<A extends Annotation> {
	@ExecuteProcessor
	public void init(A conventionAnnotation);
	
	//to init from external file
	public default void init(Map<String,String> parameters){
		throw new UnsupportedOperationException();
	}
	
	public boolean isConventionPresent(AnnotatedElement element);


}
