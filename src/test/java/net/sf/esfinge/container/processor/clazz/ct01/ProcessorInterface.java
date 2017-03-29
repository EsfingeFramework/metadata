package net.sf.esfinge.container.processor.clazz.ct01;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;

import net.sf.esfinge.metadata.annotation.container.ExecuteProcessor;

public interface ProcessorInterface {
	
	@ExecuteProcessor
	public void processorInitializationMethod(Annotation ann);

	public void processorInitializationMethodAndAnnotedElement(AnnotatedElement ael, Annotation ann);
	
	public void entidade2(Annotation ann, AnnotatedElement ael, Container annotc);


}
