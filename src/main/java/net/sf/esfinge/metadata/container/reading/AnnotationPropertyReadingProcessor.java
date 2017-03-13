package net.sf.esfinge.metadata.container.reading;

import static org.apache.commons.beanutils.PropertyUtils.setProperty;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

import net.sf.esfinge.metadata.AnnotationFinder;
import net.sf.esfinge.metadata.AnnotationReadingException;
import net.sf.esfinge.metadata.AnnotationValidationException;
import net.sf.esfinge.metadata.annotation.container.AnnotationProperty;
import net.sf.esfinge.metadata.container.AnnotationReadingProcessor;
import net.sf.esfinge.metadata.container.ContainerTarget;

public class AnnotationPropertyReadingProcessor implements AnnotationReadingProcessor {

	private Field fieldAnnoted;
	private Class<? extends Annotation> annotationThatNeedToContains;
	private AnnotationProperty annot;

	@Override
	public void initAnnotation(Annotation an, Field field) {

		fieldAnnoted = field;
		annot = (AnnotationProperty) an;
		annot.property();
		annotationThatNeedToContains = annot.annotation();
	}

	@Override
	public void read(AnnotatedElement elementWithMetadata, Object container, ContainerTarget enumStr)
			throws AnnotationReadingException {
		try {
			if (AnnotationFinder.existAnnotation(elementWithMetadata, annotationThatNeedToContains)) {

				// TODO Remover getDeclaredAnnotation

				for (Annotation annotation : AnnotationFinder.findAnnotation(elementWithMetadata,
						annotationThatNeedToContains)) {
					for (Method methodAnotation : annotation.annotationType().getDeclaredMethods()) {
						if (methodAnotation.getName().equals(annot.property())) {
							if (methodAnotation.getReturnType().equals(fieldAnnoted.getType())) {
								setProperty(container, fieldAnnoted.getName(), methodAnotation.invoke(annotation));
							} else {
								throw new AnnotationValidationException("The field " + fieldAnnoted.getName()
										+ " expected to return " + fieldAnnoted.getType()
										+ " instead is receiving " + methodAnotation.getReturnType());
							}
						}
					}
				}
			}
		} catch (Exception e) {
			throw new AnnotationReadingException("Cannot read and record the AnnotationProperty: /n As field"
					+ fieldAnnoted + "annotation " + annotationThatNeedToContains.getName(), e);
		}
	}

}
