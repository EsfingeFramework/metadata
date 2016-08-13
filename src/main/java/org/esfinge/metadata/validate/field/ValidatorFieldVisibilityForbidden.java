package org.esfinge.metadata.validate.field;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.esfinge.metadata.AnnotationValidationException;
import org.esfinge.metadata.AnnotationValidator;
import org.esfinge.metadata.annotation.validator.field.FieldVisibilityForbidden;

public class ValidatorFieldVisibilityForbidden implements AnnotationValidator {
	
	private String visibility = "";
//	private boolean ignoreWhenNotField = true;
	
	@Override
	public void initialize(Annotation self) {		
		FieldVisibilityForbidden fvf = (FieldVisibilityForbidden) self;		
		visibility = fvf.itCannotHaveThisVisibility();	
//		ignoreWhenNotField = fvf.ignoreWhenNotField();		
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
				if( !( modifiers.contains("public") || modifiers.contains("private") || modifiers.contains("protected") ) ){						
					String error = getErrorMessage(classConcrete, field, 
													toValidate.annotationType(), 
													modifiers + " default", 
													"default");	
					throw new AnnotationValidationException(error);
				}
			} else {								
				if(modifiers.contains(visibility)){
					String error = getErrorMessage(classConcrete, field, 
													toValidate.annotationType(), 
													modifiers, 
													visibility);
					throw new AnnotationValidationException(error);
				}
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
									String modifiers,
									String visibility) {		
		
		return "The field " + field.getName() + " in the " + classConcrete.getSimpleName() 
				+ " is using the @" + classOfAnnotationInField.getSimpleName() 
				+ " annotation, with this(these) modifier(s): " + modifiers 
				+ ", however it is forbidden to use this: " + visibility + ".\n";
	}
	
}
