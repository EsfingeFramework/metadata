package org.esfinge.metadata.foo.validator.implementation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.esfinge.metadata.foo.annotation.visibility.FieldVisibilityForbidden;
import org.esfinge.metadata.foo.validator.ValidatorInterface;

public class ValidatorFieldVisibilityForbidden implements ValidatorInterface {
	
	private Class<FieldVisibilityForbidden> annotation = FieldVisibilityForbidden.class;
			
	private String getErrorMessage(Class<?> classConcrete, 
									Field field,			
									Class<? extends Annotation> classOfAnnotationInField,
									String modifiers,
									String visibility) {		
		
		return "The field " + field.getName() + " in the " + classConcrete.getSimpleName() 
				+ " is using the @" + classOfAnnotationInField.getSimpleName() 
				+ " annotation, with this(these) modifier(s): " + modifiers 
				+ ", however it is forbidden to use this: " + visibility + ".\n";
	}
	
	@Override	
	public String verifyValidAnnotation(Class<?> classConcrete, Field field,
										Class<? extends Annotation> classOfAnnotationInField, 
										Class<? extends Annotation> classOfSubAnnotation) {
		
		String error = "";
		
		if(classOfAnnotationInField.isAnnotationPresent(annotation)){
			String modifiers = Modifier.toString(field.getModifiers());

			FieldVisibilityForbidden fvf = classOfAnnotationInField.getAnnotation(annotation);			
			String visibility = fvf.itCannotHaveThisVisibility();
			
			if(visibility.equals("default") || visibility.equals("")){					
				if( !( modifiers.contains("public") || modifiers.contains("private") || modifiers.contains("protected") ) )						
					error = getErrorMessage(classConcrete, field, 
											classOfAnnotationInField, 
											modifiers + " default", 
											"default");			
			} else {								
				if(modifiers.contains(visibility))
					error = getErrorMessage(classConcrete, field, 
											classOfAnnotationInField, 
											modifiers, 
											visibility);				
			}
			
		}
		
		return error;
	}
}
