package net.sf.esfinge.containerProcessosrsTest;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;

import net.sf.esfinge.metadata.annotation.container.InitProcessor;


public class DominioSegundo implements ProcessorInterface {
	
	//private String field1;
	
	//private int field2;

	@Override
	public void processorInitializationMethod(Annotation ann) {
		// TODO Auto-generated method stub
		System.out.println("Annotation "+ann);
	}

	@Override
	public void processorInitializationMethodAndAnnotedElement(AnnotatedElement ael, Annotation ann) {
		// TODO Auto-generated method stub
		System.out.println("Annotation "+ann);
		System.out.println("AnnotatedElement "+ael);
		
	}
	
	//@InitProcessor
	//public void entidade2(Annotation annot, 
	//		Annotation value, Container annotc){}

}
