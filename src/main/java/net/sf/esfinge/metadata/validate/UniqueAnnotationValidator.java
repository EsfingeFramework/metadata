package net.sf.esfinge.metadata.validate;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import net.sf.esfinge.metadata.AnnotationPropertyValidator;
import net.sf.esfinge.metadata.AnnotationValidationException;
import net.sf.esfinge.metadata.annotation.validator.Unique;

public class UniqueAnnotationValidator implements AnnotationPropertyValidator {

	private List<Annotation> annotationList = new ArrayList<Annotation>();

	@Override
	public void initialize(Annotation self) {

	}
	
	@Override
	public void validate(Annotation annotationOnElement,
			AnnotatedElement annotatedWithMainAnnotation,
			Method annotatedWithValidation, Object annotationPropertyValue)
			throws AnnotationValidationException {	
		
		Method[] methods = annotationOnElement.annotationType().getMethods();
		
		for (Method m : methods) {
			for(Annotation an : m.getAnnotations()){
				if(an instanceof Unique){
					annotationList.add(an);
				}
			}
		}
		
		if(annotationList.size() > 1){
			throw new
			AnnotationValidationException("The @"+annotationOnElement.annotationType().getSimpleName()+" must have only one field annotated with @Unique!");
		}else if (annotationList.size() == 0 ) {
			throw new AnnotationValidationException("The annotation @"
					+ Unique.class.getSimpleName().toString()							
					+ " was not found");
		}
	}	
}
