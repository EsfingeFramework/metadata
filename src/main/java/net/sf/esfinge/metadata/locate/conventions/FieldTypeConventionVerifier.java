package net.sf.esfinge.metadata.locate.conventions;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.util.Map;

import net.sf.esfinge.metadata.locate.conventions.annotations.FieldTypeConvention;

public class FieldTypeConventionVerifier implements ConventionVerifier<FieldTypeConvention>{
	
	private Class<?> type;
	private boolean canBeSubtype;

	@Override
	public void init(FieldTypeConvention conventionAnnotation) {
		type = conventionAnnotation.type();
		canBeSubtype = conventionAnnotation.canBeSubtype();
	}
	@Override
	public void init(Map<String,String> parameters)  {
		try {
			type= Class.forName(parameters.get("type"));
			canBeSubtype = Boolean.getBoolean(parameters.get("canBeSubtype"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
	@Override
	public boolean isConventionPresent(AnnotatedElement element) {
		if(element instanceof Field) {
			Field field = (Field) element;
			if(canBeSubtype) {
				return type.isAssignableFrom(field.getType());
			}else {
				return type == field.getType();
			}
		}
		return false;
	}
}