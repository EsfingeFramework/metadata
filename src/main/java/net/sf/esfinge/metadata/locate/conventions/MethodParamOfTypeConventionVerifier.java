package net.sf.esfinge.metadata.locate.conventions;

import java.lang.reflect.AnnotatedElement;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

import net.sf.esfinge.metadata.locate.conventions.annotations.MethodParamOfTypeConvention;

public class MethodParamOfTypeConventionVerifier implements ConventionVerifier<MethodParamOfTypeConvention> {

	private Class<?>[] parameters;
	private boolean canBeSubtype;
	@Override
	public void init(MethodParamOfTypeConvention conventionAnnotation) {
		parameters = new Class<?>[conventionAnnotation.parameters().length];
		for (int i = 0; i < conventionAnnotation.parameters().length; i++) {
			parameters[i] = conventionAnnotation.parameters()[i];

		}
		canBeSubtype = conventionAnnotation.canBeSubtype();

	}

	@Override
	public boolean isConventionPresent(AnnotatedElement element) {
		if (element instanceof Method) {
			Method method = (Method) element;
			Parameter[] params = method.getParameters();
			for (int i = 0; i < parameters.length; i++) {
				for(int j=0;j<params.length;j++){
					if (params[j].getType() == parameters[i]) {
						return true;
					}else if (canBeSubtype){
						if (parameters[i].isAssignableFrom(params[j].getType())) {
							return true;
						}
					}
				}

			}
			return false;
		}
		return false;
	}

}
