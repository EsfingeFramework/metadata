package org.esfinge.metadata.validate.field;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.esfinge.metadata.AnnotationValidationException;
import org.esfinge.metadata.AnnotationValidator;
import org.esfinge.metadata.annotation.validator.field.FinalFieldOnly;

public class ValidatorFinalFieldOnly implements AnnotationValidator {
	
	private String modifiersNameObliged = "";
//	private boolean ignoreWhenNotField = true;
	
	@Override
	public void initialize(Annotation self) {
		FinalFieldOnly fieldOnly = (FinalFieldOnly) self;		
		modifiersNameObliged = "final";			
//		ignoreWhenNotField = fieldOnly.ignoreWhenNotField();		
	}

	@Override
	public void validate(Annotation toValidate, 
							AnnotatedElement annotated)
									throws AnnotationValidationException {
		
//		toValidate - anotação que tem a anotação, tipo "OneAnnotationWithInstanceFieldOnly"
//		annotated - field ou method que tem a anotacao acima
		
		if(annotated instanceof Field){			
			Field field = (Field) annotated;						
			Class<?> classConcrete = field.getDeclaringClass();  // ex.: Person.class
						
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
//		else if(annotated instanceof Method){
//			
//			Method method = (Method) annotated;	
//			
//			if(!ignoreWhenNotField){				
//				System.out.println("Verifying in method... InstanceFieldOnly");				
//			}else{				
//				System.out.println("Ignoring in method... InstanceFieldOnly");				
//			}
//			
//		}else{
//			System.out.println("idk .-.");
//		}				
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
