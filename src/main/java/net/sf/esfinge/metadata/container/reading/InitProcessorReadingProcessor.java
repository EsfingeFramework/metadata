package net.sf.esfinge.metadata.container.reading;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;

import net.sf.esfinge.metadata.AnnotationReadingException;
import net.sf.esfinge.metadata.AnnotationValidationException;
import net.sf.esfinge.metadata.annotation.container.InitProcessor;
import net.sf.esfinge.metadata.container.AnnotationReadingProcessor;
import net.sf.esfinge.metadata.container.ContainerTarget;

public class InitProcessorReadingProcessor implements AnnotationReadingProcessor {

	InitProcessor initProcessor;
	Object classe;
	
	
	@Override
	public void initAnnotation(Annotation an, Field field) throws AnnotationValidationException {
		// TODO Auto-generated method stub
		initProcessor =(InitProcessor)an;
		

	}

	@Override
	public void read(AnnotatedElement classWithMetadata, Object container, ContainerTarget enumStr)
			throws AnnotationReadingException {
		// TODO Auto-generated method stub

	}

}
