package net.sf.esfinge.metadata.locate.conventions;

import java.lang.reflect.AnnotatedElement;

import net.sf.esfinge.metadata.locate.conventions.annotations.ClassTypeConvention;

public class ClassTypeConventionVerifier implements ConventionVerifier<ClassTypeConvention> {

	
	private Class<?> superClass;
	private boolean canBeSubtype;
	@Override
	public void init(ClassTypeConvention conventionAnnotation) {
		superClass = conventionAnnotation.superClass();
		canBeSubtype = conventionAnnotation.canBeSubtype();

	}

	@Override
	public boolean isConventionPresent(AnnotatedElement element) {
		if (element instanceof Class<?>) {

			if(canBeSubtype){
				for(int i=0;i<((Class<?>) element).getInterfaces().length;i++){
					if(((Class<?>) element).getInterfaces()[i].isAssignableFrom(superClass)) {
						return true;
					}
				}
				return superClass.isAssignableFrom(((Class<?>) element).getSuperclass());
			}else{
				return superClass == element.getClass();
			}

		}
		return false;
	}
}
