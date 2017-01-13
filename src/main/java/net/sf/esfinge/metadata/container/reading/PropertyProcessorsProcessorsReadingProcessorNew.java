package net.sf.esfinge.metadata.container.reading;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;

import net.sf.esfinge.metadata.AnnotationReadingException;
import net.sf.esfinge.metadata.AnnotationValidationException;
import net.sf.esfinge.metadata.annotation.container.AnnotationPropertyLocation;
import net.sf.esfinge.metadata.annotation.container.PropertyProcessorsNew;
import net.sf.esfinge.metadata.container.AnnotationReadingProcessor;
import net.sf.esfinge.metadata.container.ContainerTarget;

public class PropertyProcessorsProcessorsReadingProcessorNew implements AnnotationReadingProcessor{

	PropertyProcessorsNew annotation;
	Field field;
	
	@Override
	public void initAnnotation(Annotation an, Field field) throws AnnotationValidationException {

		annotation = (PropertyProcessorsNew) an;
		this.field = field;
	}

	@Override
	public void read(AnnotatedElement elementWithMetadata, Object container, ContainerTarget target)
			throws AnnotationReadingException {
		
		
		if(annotation.value()==AnnotationPropertyLocation.ATTRIBUTE_ONLY)
		{
			
		}
		else if(annotation.value()==AnnotationPropertyLocation.GETTER_ONLY)
		{
			
		}
		else if(annotation.value()==AnnotationPropertyLocation.SETTER_ONLY)
		{
			
		}
		else if(annotation.value()==AnnotationPropertyLocation.ATTRIBUTE_GETTER)
		{
			
		}
		else if(annotation.value()==AnnotationPropertyLocation.ATTRIBUTE_SETTER)
		{
			
		}
	}

}
