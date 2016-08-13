package org.esfinge.metadata.validate.field;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.esfinge.metadata.AnnotationValidationException;
import org.esfinge.metadata.AnnotationValidator;
import org.esfinge.metadata.annotation.validator.field.FieldVisibilityRequired;

public class ValidatorFieldVisibilityRequired implements AnnotationValidator {
	
	private String visibility = "";
	private boolean ignoreWhenNotField = true;
	
	@Override
	public void initialize(Annotation self) {
		
//		self - anotacao para validar, anotacao da anotacao	
		
		FieldVisibilityRequired fvr = (FieldVisibilityRequired) self;		
		visibility = fvr.itNeedsToHaveThisVisibility();	
		ignoreWhenNotField = fvr.ignoreWhenNotField();
		
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
			
		}else if(annotated instanceof Method){
			
			Method method = (Method) annotated;	
			
			if(!ignoreWhenNotField){				
				System.out.println("Verifying in method... InstanceFieldOnly");				
			}else{				
				System.out.println("Ignoring in method... InstanceFieldOnly");				
			}
			
		}else{
			System.out.println("idk .-.");
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
	
	
	
	
	
//	public String verifyValidAnnotationInField(Class<?> classConcrete, 
//												Field field,
//												Class<? extends Annotation> classOfAnnotationInField, 
//												Class<? extends Annotation> classOfSubAnnotation) {
//		String error = "";
//			
//		if(classOfAnnotationInField.isAnnotationPresent(annotation)
//												&& classOfSubAnnotation.equals(annotation)){
//			
//			String modifiers = Modifier.toString(field.getModifiers());
//
//			FieldVisibilityRequired fvr = classOfAnnotationInField.getAnnotation(annotation);	
//			
//			String visibility = fvr.itNeedsToHaveThisVisibility();
//			
//			if(visibility.equals("default") || visibility.equals("")){					
//				if( modifiers.contains("public") || modifiers.contains("private") || modifiers.contains("protected") )						
//					error = getErrorMessage(classConcrete, field, 
//											classOfAnnotationInField, modifiers, 
//											"default");
//				
//			} else {				
//				if(!modifiers.contains(visibility))
//					error = getErrorMessage(classConcrete, field,
//											classOfAnnotationInField, modifiers, 
//											visibility);	
//				
//			}
//			
//		}
//		
//		return error;
//	}
		
//	public String verifyValidAnnotationInMethod(Class<?> classConcrete,
//												Method method,
//												Class<? extends Annotation> classOfAnnotationInMethod, 
//												Class<? extends Annotation> classOfSubAnnotation) {
//		
//		String error = "";
//		
//		if(classOfAnnotationInMethod.isAnnotationPresent(annotation)
//													&& classOfSubAnnotation.equals(annotation)){			
//			
//			FieldVisibilityRequired fvr = classOfAnnotationInMethod.getAnnotation(annotation);			
//			boolean ignoreWhenNotField = fvr.ignoreWhenNotField();
//			
//			if(!ignoreWhenNotField){
//				
//				System.out.println("Verifying in method... FieldVisibilityRequired");
//				
//			}else{
//				
//				System.out.println("Ignoring in method... FieldVisibilityRequired");
//				
//			}
//			
//		}		
//		
//		return error;
//	}

	
}
