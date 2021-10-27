package net.sf.esfinge.metadata.locate.conventions;

import java.lang.reflect.AnnotatedElement;

import net.sf.esfinge.metadata.locate.conventions.annotations.ClassTypeConvention;

public class ClassTypeConventionVerifier implements ConventionVerifier<ClassTypeConvention> {

	
	private Class<?> superClass;
	
	@Override
	public void init(ClassTypeConvention conventionAnnotation) {
		superClass = conventionAnnotation.superClass();
		
	}

	@Override
	public boolean isConventionPresent(AnnotatedElement element) {
		if (element instanceof Class<?>) {
			Class<?> clazz = (Class<?>) element;
			return superClass == clazz.getSuperclass();
		}
		return false;
	}
}
