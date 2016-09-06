package net.sf.esfinge.metadata.validate;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;

import net.sf.esfinge.metadata.AnnotationFinder;
import net.sf.esfinge.metadata.AnnotationPropertyValidator;
import net.sf.esfinge.metadata.AnnotationValidationException;
import net.sf.esfinge.metadata.annotation.validator.RefersTo;

public class RefersToAnnotationValidator implements AnnotationPropertyValidator {

	private Class<? extends Annotation> annotationToSearch;
	private String attributeValue;

	@Override
	public void initialize(Annotation self) {
		RefersTo rt = (RefersTo) self;

		annotationToSearch = rt.annotation();
		attributeValue = rt.attributeValue();
	}

	@Override
	public void validate(Annotation annotationOnElement,
			AnnotatedElement annotatedWithMainAnnotation,
			Method annotatedWithValidation, Object annotationPropertyValue)
			throws AnnotationValidationException {
		if (AnnotationFinder.findAnnotation(annotatedWithMainAnnotation,
				annotationToSearch).size() > 0) {
			String value = (String) annotationPropertyValue;
			if (value.equals(attributeValue)) {
				throw new AnnotationValidationException("The attribute "
						+ annotatedWithValidation.getName() + " of @"
						+ annotationOnElement.annotationType().getName()
						+ " has a value(" + value + ")"
						+ ", which is not equals to @RefersTo("
						+ attributeValue + ")");
			}
		}
	}
}
