package net.sf.esfinge.metadata.validate.field;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import net.sf.esfinge.metadata.AnnotationValidationException;

public class UtilValidatorModifierFieldOnly{
	
	private String modifiersNameObliged = "";
	
	public void setModifiersNameObliged(String modifiersNameObliged){
		this.modifiersNameObliged = modifiersNameObliged;		
	}
		
	public void validate(Annotation toValidate, 
							AnnotatedElement annotated)
									throws AnnotationValidationException {		
		
		if(annotated instanceof Field){			
			Field field = (Field) annotated;						
			Class<?> classConcrete = field.getDeclaringClass();  
						
			String modifiers = Modifier.toString(field.getModifiers());
			
			if(!modifiers.contains(modifiersNameObliged)){			
				if(modifiers.equals("")) modifiers = "default";
							
				String error = getErrorMessage(classConcrete, 
												field, 
												toValidate.annotationType(), 
												modifiersNameObliged, 
												modifiers);				
				throw new AnnotationValidationException(error);			
			}			
		}
				
	}
	
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
	
}
