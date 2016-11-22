package net.sf.esfinge.metadata.container.reading;

import static org.apache.commons.beanutils.PropertyUtils.setProperty;

import java.awt.List;
import java.beans.PropertyDescriptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.objectweb.asm.tree.analysis.Value;

import net.sf.esfinge.metadata.AnnotationReadingException;
import net.sf.esfinge.metadata.annotation.container.ContainerFor;
import net.sf.esfinge.metadata.annotation.container.ReflectionReference;
import net.sf.esfinge.metadata.container.AnnotationReadingProcessor;
import net.sf.esfinge.metadata.container.ContainerTarget;

public class ReflectionReferenceReadingProcessor implements AnnotationReadingProcessor {

	private String containerAnnotatedField;
	private ReflectionReference refl;

	@Override
	public void initAnnotation(Annotation an, Field field) {
		containerAnnotatedField = field.getName();
		refl = (ReflectionReference) an;

	}

	@Override
	public void read(AnnotatedElement elementWithMetadata, Object container, ContainerTarget target)
			throws AnnotationReadingException {
		try {

			if (target.equals(ContainerTarget.TYPE)) {
				setProperty(container, containerAnnotatedField, elementWithMetadata);
			} else if (target.equals(ContainerTarget.FIELDS)) {
				Field fieldAnnoted = (Field) elementWithMetadata;

				setProperty(container, containerAnnotatedField, fieldAnnoted.getType());
			} else if (target.equals(ContainerTarget.METHODS)) {
				Method methodAnnoted = (Method) elementWithMetadata;

				setProperty(container, containerAnnotatedField, methodAnnoted.getClass());
			} else if (target.equals(ContainerTarget.ALL)) {

				//PEGAR A CLASSE
				//METODO
				//VERIFICAR SE TEM MAIS DE UM PARAMETRO
				//VERIFICAR
				Map<String, Object> x = PropertyUtils.describe(elementWithMetadata);
				PropertyDescriptor[] describe = PropertyUtils.getPropertyDescriptors(elementWithMetadata);
				 Object y = x.get("genericType");
					Field fieldAnnoted = (Field) elementWithMetadata;
					Class<?> targetType = fieldAnnoted.getDeclaringClass();
					String propName;
					if(!fieldAnnoted.getType().equals(boolean.class)){
						 propName = propertyToGetter(fieldAnnoted.getName());
					}
					else
					{
						propName = propertyToGetter(fieldAnnoted.getName(), false);
					}
					System.out.println(targetType);
				if(targetType.getMethod(propName).getDeclaredAnnotations().length>1)
				{
					setProperty(container, containerAnnotatedField, y);

				}
				else
				{
					setProperty(container, containerAnnotatedField, fieldAnnoted.getType());

				}
				
				
			} else {

				Field fieldAnnoted = (Field) elementWithMetadata;
				setProperty(container, containerAnnotatedField, fieldAnnoted.getType());
			}

		} catch (Exception e) {
			throw new AnnotationReadingException(
					"Cannot read and record the file " + elementWithMetadata + "in " + containerAnnotatedField, e);
		}
	}

	public static String propertyToGetter(String propertieName) {
		return propertyToGetter(propertieName, false);
	}

	public static String propertyToGetter(String propertieName, boolean isBoolean) {
		if (isBoolean)
			return "is" + propertieName.substring(0, 1).toUpperCase() + propertieName.substring(1);
		return "get" + propertieName.substring(0, 1).toUpperCase() + propertieName.substring(1);
	}

}
