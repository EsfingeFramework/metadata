package org.esfinge.metadata.foo.validator.implementation;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.esfinge.metadata.AnnotationValidationException;
import org.esfinge.metadata.AnnotationValidator;
import org.esfinge.metadata.foo.annotation.fieldonly.InstanceFieldOnly;

public class ValidatorInstanceFieldOnly implements AnnotationValidator{

	private boolean ignoreWhenNotField = true;
	
	@Override
	public void initialize(Annotation self) {
		
//		self - anotacao para validar, anotacao da anotacao		
		InstanceFieldOnly instanceFieldOnly = (InstanceFieldOnly) self;		
		ignoreWhenNotField = instanceFieldOnly.ignoreWhenNotField();	
		
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
									Class<?> classOfAnnotationInField,
									String modifiers) {		

		return "The field " + field.getName() + " in the " + classConcrete.getSimpleName() 
				+ " is using the @" + classOfAnnotationInField.getSimpleName() 
				+ " annotation, however it has static modifier.\n"
				+ "(it has this(these) modifier(s): " + modifiers + " )";
		
	}
	
	
//		
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
//			if(modifiers.contains("static"))
//				error = getErrorMessage(classConcrete, 
//										field,
//										classOfAnnotationInField, 
//										modifiers);			
//		}
//		
//		return error;
//	}
//
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
//			InstanceFieldOnly ifo = classOfAnnotationInMethod.getAnnotation(annotation);			
//			boolean ignoreWhenNotField = ifo.ignoreWhenNotField();
//			
//			if(!ignoreWhenNotField){
//				
//				System.out.println("Verifying in method... InstanceFieldOnly");
//				
//			}else{
//				
//				System.out.println("Ignoring in method... InstanceFieldOnly");
//				
//			}
//			
//		}		
//		
//		return error;
//	}
	
	
}
