package net.sf.esfinge.container.processor.Field;

import java.lang.annotation.Annotation;

import net.sf.esfinge.metadata.annotation.container.ExecuteProcessor;

public interface ProcessorInterface {
	
	@ExecuteProcessor
	public void processorInitializationMethod(Annotation ann);

//	@ExecuteProcessor
//	public void processorInitializationMethodAndAnnotedElement(AnnotatedElement ael, Annotation ann);
	
//	@ExecuteProcessor
//	public void entidade2(Annotation ann, AnnotatedElement ael, ContainerMapField annotc);


}
