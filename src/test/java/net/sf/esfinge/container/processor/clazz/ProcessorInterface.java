package net.sf.esfinge.container.processor.clazz;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;

import net.sf.esfinge.metadata.annotation.container.InitProcessor;

public interface ProcessorInterface {
	
	@InitProcessor
	public void processorInitializationMethod(Annotation ann);

	@InitProcessor
	public void processorInitializationMethodAndAnnotedElement(AnnotatedElement ael, Annotation ann);
	
	@InitProcessor
	public void entidade2(Annotation ann, AnnotatedElement ael, Container annotc);


}
