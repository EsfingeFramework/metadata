package org.esfinge.metadata;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;

public interface AnnotationValidator {

	public void initialize(Annotation self);

	public void validate(Annotation toValidate, AnnotatedElement annotated)
			throws AnnotationValidationException;

}
