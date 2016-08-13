package org.esfinge.metadata.validate.field;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.esfinge.metadata.AnnotationValidationException;
import org.esfinge.metadata.AnnotationValidator;
import org.esfinge.metadata.annotation.validator.field.InstanceFieldOnly;

public class ValidatorInstanceFieldOnly implements AnnotationValidator{

//	private boolean ignoreWhenNotField = true;
	
	@Override
	public void initialize(Annotation self) {	
		InstanceFieldOnly instanceFieldOnly = (InstanceFieldOnly) self;		
//		ignoreWhenNotField = instanceFieldOnly.ignoreWhenNotField();		
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
						
			if(modifiers.contains("static")){
				String error = getErrorMessage(classConcrete, 
												field,
												toValidate.annotationType(), 
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
									Class<?> classOfAnnotationInField,
									String modifiers) {		

		return "The field " + field.getName() + " in the " + classConcrete.getSimpleName() 
				+ " is using the @" + classOfAnnotationInField.getSimpleName() 
				+ " annotation, however it has static modifier.\n"
				+ "(it has this(these) modifier(s): " + modifiers + " )";		
	}	
	
}
