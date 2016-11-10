package net.sf.esfinge.metadata.container.reading;

import static org.apache.commons.beanutils.PropertyUtils.setProperty;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.omg.CORBA.portable.ValueBase;

import net.sf.esfinge.metadata.AnnotationReadingException;
import net.sf.esfinge.metadata.annotation.container.ContainerFor;
import net.sf.esfinge.metadata.container.AnnotationReadingProcessor;
import net.sf.esfinge.metadata.container.ContainerTarget;

public class ReflectionReferenceReadingProcessor implements AnnotationReadingProcessor {
	
	private String containerAnnotatedField;

	@Override
	public void initAnnotation(Annotation an, Field field) {
		containerAnnotatedField = field.getName();
	}

	@Override
	public void read(AnnotatedElement elementWithMetadata, Object container, ContainerTarget target) throws AnnotationReadingException {
		try {

			if(target.equals(ContainerTarget.TYPE))
			{
				setProperty(container, containerAnnotatedField,elementWithMetadata);
			}
			else if(target.equals(ContainerTarget.FIELDS))
			{
				Field fieldAnnoted = (Field) elementWithMetadata;

				setProperty(container, containerAnnotatedField,fieldAnnoted.getType());
			}
			else if(target.equals(ContainerTarget.METHODS))
			{
				Method methodAnnoted = (Method) elementWithMetadata;

				setProperty(container, containerAnnotatedField,methodAnnoted.getClass());
			}
			else if(target.equals(ContainerTarget.ALL))
			{
				
				if(elementWithMetadata.getClass().equals(Field.class))
				{
					Field fieldAnnoted = (Field) elementWithMetadata;
					setProperty(container, containerAnnotatedField,fieldAnnoted.getType());
				}
			}
			
		
		} catch (Exception e) {
			throw new AnnotationReadingException("Cannot read and record the file "+elementWithMetadata+"in "+containerAnnotatedField,e);
		}
	}

}
