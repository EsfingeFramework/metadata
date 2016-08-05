package org.esfinge.metadata.foo.validator.implementation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.esfinge.metadata.foo.annotation.fieldonly.InstanceFieldOnly;
import org.esfinge.metadata.foo.validator.ValidatorInterface;

public class ValidatorInstanceFieldOnly implements ValidatorInterface {
		
	private String getErrorMessage(Class<?> classConcrete, 
									Field field,			
									Class<? extends Annotation> classOfAnnotationInField,
									String modifiers) {		

		return "The field " + field.getName() + " in the " + classConcrete.getSimpleName() 
				+ " is using the @" + classOfAnnotationInField.getSimpleName() 
				+ " annotation, however it has static modifier.\n"
				+ "(it has this(these) modifier(s): " + modifiers + " )";
		
	}
	
	@Override	
	public String verifyValidAnnotation(Class<?> classConcrete, Field field,
										Class<? extends Annotation> classOfAnnotationInField, 
										Class<? extends Annotation> classOfSubAnnotation) {
		String error = "";
		
//		if(classOfAnnotationInField.isAnnotationPresent(InstanceFieldOnly.class)){			
		if(classOfAnnotationInField.isAnnotationPresent(InstanceFieldOnly.class)
									&& classOfSubAnnotation.equals(InstanceFieldOnly.class)){
			
			String modifiers = Modifier.toString(field.getModifiers());
			
			if(modifiers.contains("static"))
				error = getErrorMessage(classConcrete, field,
										classOfAnnotationInField, 
										modifiers);
			
		}
		
		return error;
	}
	
	
	
	
	
	
	
}
