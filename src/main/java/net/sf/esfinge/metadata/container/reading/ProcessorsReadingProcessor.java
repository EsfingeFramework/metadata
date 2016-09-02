package net.sf.esfinge.metadata.container.reading;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;

import net.sf.esfinge.metadata.AnnotationReadingException;
import net.sf.esfinge.metadata.AnnotationValidationException;
import net.sf.esfinge.metadata.container.AnnotationReadingProcessor;
import net.sf.esfinge.metadata.container.ContainerTarget;

public class ProcessorsReadingProcessor implements AnnotationReadingProcessor{

	@Override
	public void initAnnotation(Annotation an, Field field) throws AnnotationValidationException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void read(AnnotatedElement classWithMetadata, Object container, ContainerTarget enumStr)
			throws AnnotationReadingException {
		// TODO Auto-generated method stub
		
	}

}
