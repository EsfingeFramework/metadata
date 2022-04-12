package net.sf.esfinge.metadata.locate.conventions;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Map;

import net.sf.esfinge.metadata.locate.conventions.annotations.MethodTypeConvention;

public class MethodTypeConventionVerifier implements ConventionVerifier<MethodTypeConvention> {

	private Class<?>[] parameters;
	private boolean canBeSubtype;
	@Override
	public void init(MethodTypeConvention conventionAnnotation) {
		parameters = new Class<?>[conventionAnnotation.parameters().length];
		for (int i = 0; i < conventionAnnotation.parameters().length; i++) {
			parameters[i] = conventionAnnotation.parameters()[i];

		}
		canBeSubtype = conventionAnnotation.canBeSubtype();

	}
	@Override
	public void init(Map<String,String> parameters)  {
		String[] annotations = parameters.get("parameters").split(",");
		this.parameters = new Class<?>[annotations.length];

		try {
			for(int i=0;i<annotations.length;i++){
				this.parameters[i] = Class.forName(annotations[i]);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		canBeSubtype = Boolean.getBoolean(parameters.get("canBeSubtype"));
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
