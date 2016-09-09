package net.sf.esfinge.containerProcessosrsTest;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;

import net.sf.esfinge.metadata.annotation.container.InitProcessor;

public interface ProcessorInterface {
	
	@InitProcessor
	public void processorInitializationMethod(Annotation ann);

	@InitProcessor
	void processorInitializationMethodAndAnnotedElement(AnnotatedElement ael, Annotation ann);

}
