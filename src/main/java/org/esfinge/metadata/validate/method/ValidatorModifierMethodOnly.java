package org.esfinge.metadata.validate.method;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.esfinge.metadata.AnnotationValidationException;

public class ValidatorModifierMethodOnly{
	
	private String modifiersNameObliged = "";
	
	public void setModifiersNameObliged(String modifiersNameObliged){
		this.modifiersNameObliged = modifiersNameObliged;		
	}
		
	public void validate(Annotation toValidate, 
							AnnotatedElement annotated)
									throws AnnotationValidationException {		
		
		if(annotated instanceof Method){			
			Method method = (Method) annotated;						
			Class<?> classConcrete = method.getDeclaringClass();  
						
			String modifiers = Modifier.toString(method.getModifiers());
			
			if(!modifiers.contains(modifiersNameObliged)){			
				if(modifiers.equals("")) modifiers = "default";
							
				String error = getErrorMessage(classConcrete, 
												method, 
												toValidate.annotationType(), 
												modifiersNameObliged, 
												modifiers);
				
				throw new AnnotationValidationException(error);			
			}			
		}
				
	}
	
	private String getErrorMessage(Class<?> classConcrete, 
									Method method,			
									Class<? extends Annotation> classOfAnnotationInField, 
									String modifiersNameObliged, 
									String modifiers) {		
	
		return "The method " + method.getName() + " in the " + classConcrete.getSimpleName() 
				+ " is using the @" + classOfAnnotationInField.getSimpleName() 
				+ " annotation, however it has no " + modifiersNameObliged + " modifier.\n"
				+ "(it has this(these) modifier(s): " + modifiers + " )";	
	}
	
}
