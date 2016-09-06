package net.sf.esfinge.metadata.validate.field;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import net.sf.esfinge.metadata.AnnotationValidationException;
import net.sf.esfinge.metadata.AnnotationValidator;
import net.sf.esfinge.metadata.annotation.validator.field.FieldVisibilityRequired;

public class ValidatorFieldVisibilityRequired implements AnnotationValidator {
	
	private String visibility = "";
	
	@Override
	public void initialize(Annotation self) {		
		FieldVisibilityRequired fvr = (FieldVisibilityRequired) self;		
		visibility = fvr.itNeedsToHaveThisVisibility();	
	}

	@Override
	public void validate(Annotation toValidate, 
							AnnotatedElement annotated)
									throws AnnotationValidationException {		
		
		if(annotated instanceof Field){			
			Field field = (Field) annotated;						
			Class<?> classConcrete = field.getDeclaringClass();  // ex.: Person.class
						
			String modifiers = Modifier.toString(field.getModifiers());
			
			if(visibility.equals("default") || visibility.equals("")){					
				if( modifiers.contains("public") || modifiers.contains("private") || modifiers.contains("protected") ){						
					String error = getErrorMessage(classConcrete, 
													field, 
													toValidate.annotationType(), 
													modifiers, 
													"default");
					throw new AnnotationValidationException(error);
				}				
			} else {				
				if(!modifiers.contains(visibility)){
					String error = getErrorMessage(classConcrete, 
													field,
													toValidate.annotationType(), 
													modifiers, 
													visibility);
					throw new AnnotationValidationException(error);
				}				
			}			
		}

	}
		
	private String getErrorMessage(Class<?> classConcrete, 
									Field field,			
									Class<? extends Annotation> classOfAnnotationInField,
									String modifiers,
									String visibility) {
		
		return "The field " + field.getName() + " in the " + classConcrete.getSimpleName() 
					+ " is using the @" + classOfAnnotationInField.getSimpleName() 
					+ " annotation, with this(these) modifier(s): " + modifiers 
					+ ", however it needs to use this: " + visibility + ".\n";
	}
	
}
