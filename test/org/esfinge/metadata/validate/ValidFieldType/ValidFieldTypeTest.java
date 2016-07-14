package org.esfinge.metadata.validate.ValidFieldType;

import static org.junit.Assert.*;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;

import org.esfinge.metadata.AnnotationValidationException;
import org.esfinge.metadata.AnnotationValidator;
import org.esfinge.metadata.annotation.container.ElementName;
import org.esfinge.metadata.validate.ValidFieldTypeValidator;
import org.junit.Test;

public class ValidFieldTypeTest {

	@Test
	public void CT01() throws NoSuchFieldException, SecurityException, AnnotationValidationException {
		
				Field field1= Ct1Container.class.getDeclaredField("teste");
				AnnotationValidator vf1 = new ValidFieldTypeValidator();
				Annotation ann1 = field1.getDeclaredAnnotation(ElementName.class);
				vf1.validate(ann1, (AnnotatedElement)field1);		
	}

}
