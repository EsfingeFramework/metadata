package net.sf.esfinge.container.processor.clazz;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;

import net.sf.esfinge.metadata.annotation.container.InitProcessor;


public class DominioSegundo implements ProcessorInterface {
	
	//private String field1;
	
	//private int field2;

	@Override
	public void processorInitializationMethod(Annotation ann) {
		// TODO Auto-generated method stub
	}

	@Override
	public void processorInitializationMethodAndAnnotedElement(AnnotatedElement ael, Annotation ann) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void entidade2(Annotation ann, 
			AnnotatedElement ael, Container annotc){
		System.out.println("Annotation "+ann);
		System.out.println("AnnotatedElement "+ael);
		System.out.println("AnnotatedElement "+annotc);
	}

}
