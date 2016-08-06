package org.esfinge.metadata.foo.validator.implementation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.esfinge.metadata.foo.annotation.fieldonly.FinalFieldOnly;
import org.esfinge.metadata.foo.annotation.fieldonly.StaticFieldOnly;
import org.esfinge.metadata.foo.annotation.fieldonly.TransientFieldOnly;
import org.esfinge.metadata.foo.annotation.fieldonly.VolatileFieldOnly;
import org.esfinge.metadata.foo.validator.ValidatorInterface;

public class ValidatorFieldOnly implements ValidatorInterface {
	
	private String getErrorMessage(Class<?> classConcrete, 
									Field field,			
									Class<? extends Annotation> classOfAnnotationInField, 
									String modifiersNameObliged, 
									String modifiers) {		
	
		return "The field " + field.getName() + " in the " + classConcrete.getSimpleName() 
				+ " is using the @" + classOfAnnotationInField.getSimpleName() 
				+ " annotation, however it has no " + modifiersNameObliged + " modifier.\n"
				+ "(it has this(these) modifier(s): " + modifiers + " )";
	
	}
	
	private String getModifiersNameObliged(Class<? extends Annotation> classOfSubAnnotation) {
	
		String modifiersNameObliged = "";
		
		if(classOfSubAnnotation.isAssignableFrom(StaticFieldOnly.class)){
		
			modifiersNameObliged = "static";	
		
		}else if(classOfSubAnnotation.isAssignableFrom(FinalFieldOnly.class)){
		
			modifiersNameObliged = "final";		
		
		}else if(classOfSubAnnotation.isAssignableFrom(TransientFieldOnly.class)){	
		
			modifiersNameObliged = "transient";	
		
		}else if(classOfSubAnnotation.isAssignableFrom(VolatileFieldOnly.class)){	
		
			modifiersNameObliged = "volatile";							
		
		}
		
		return modifiersNameObliged;
	}
	
	@Override
	public String verifyValidAnnotation(Class<?> classConcrete, Field field,
										Class<? extends Annotation> classOfAnnotationInField, 
										Class<? extends Annotation> classOfSubAnnotation) {
		String error = "";
		
		String modifiersNameObliged = getModifiersNameObliged(classOfSubAnnotation);			
		String modifiers = Modifier.toString(field.getModifiers());	
		
		if(!modifiers.contains(modifiersNameObliged)){			
			if(modifiers.equals("")) modifiers = "default";
						
			error = getErrorMessage(classConcrete, field, classOfAnnotationInField, 
						modifiersNameObliged, modifiers);
		
		}
		
		return error;
	}
	
	@Override
	public String verifyValidAnnotationInMethod(Class<?> classConcrete,
												Method method,
												Class<? extends Annotation> classOfAnnotationInMethod, 
												Class<? extends Annotation> classOfSubAnnotation) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
