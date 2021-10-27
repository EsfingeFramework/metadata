package net.sf.esfinge.metadata.locate.conventions;

import java.lang.reflect.AnnotatedElement;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

import net.sf.esfinge.metadata.locate.conventions.annotations.MethodTypeConvention;

public class MethodTypeConventionVerifier implements ConventionVerifier<MethodTypeConvention> {

	private Class<?>[] parameters;

	@Override
	public void init(MethodTypeConvention conventionAnnotation) {
		for (int i = 0; i < conventionAnnotation.parameters().length; i++) {
			parameters[i] = conventionAnnotation.parameters()[i];
		}

	}

	@Override
	public boolean isConventionPresent(AnnotatedElement element) {
		if (element instanceof Method) {
			Method method = (Method) element;
			Parameter[] params = method.getParameters();
			for (int i = 0; i < params.length; i++) {
				for(int j=0;j<parameters.length;j++){
					if (params[j].getClass() == parameters[i]) {
						return true;
					}
				}

			}
			return false;
		}
		return false;
	}

}
