package net.sf.esfinge.metadata.locate.conventions;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;

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