package org.esfinge.metadata.validate.field;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;

import org.esfinge.metadata.AnnotationValidationException;
import org.esfinge.metadata.AnnotationValidator;
import org.esfinge.metadata.annotation.validator.field.ValidFieldTypes;

public class ValidatorValidFieldTypes implements AnnotationValidator {
	
	private Class<?>[] listValidTypes = {};
//	private boolean ignoreWhenNotField = true;
	
	@Override
	public void initialize(Annotation self) {		
		ValidFieldTypes vft = (ValidFieldTypes) self;		
		listValidTypes = vft.listValidTypes();	
//		ignoreWhenNotField = vft.ignoreWhenNotField();				
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
						
			Class<?> type = field.getType();
						
			boolean found = false;
			for(Class<?> oneValidType: listValidTypes){	
								
				if(type.isPrimitive() && type.toString().equals(oneValidType.toString()))
					found = true;
				
//				List -> List // String -> String
				else if(type.isAssignableFrom(oneValidType))				
					found = true;
				
//				List -> ArrayList
				else if(oneValidType.isAssignableFrom(type))
					found = true;
				
			}
			
			if(!found){			
				String error = getErrorMessage(classConcrete, 
												field, 
												toValidate.annotationType(), 
												type, 
												listValidTypes);
				
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
	
	public String getErrorMessage(Class<?> clazz, 
									Field field, 
									Class<? extends Annotation> classOfAnnotationInField,
									Class<?> type, 
									Class<?>[] listValidTypes){
		
		StringBuilder concatedListValidTypes = new StringBuilder();
		concatedListValidTypes.append("[");
		for(Class<?> oneValidType: listValidTypes){
			concatedListValidTypes.append(oneValidType.getSimpleName());
			concatedListValidTypes.append(", ");
		}
		concatedListValidTypes.append("]");
		
		return "The field " + field.getName() + " in the " + clazz.getSimpleName() 
				+ " is using the @" + classOfAnnotationInField.getSimpleName() 
				+ " annotation, its type is " + type.getSimpleName() 
				+ ", however it is not in the list of valid types (list: " + concatedListValidTypes.toString() + "): .\n";
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
//			Class<?> type = field.getType();
//						
//			ValidFieldTypes fvf = classOfAnnotationInField.getAnnotation(annotation);			
//			Class<?>[] listValidTypes = fvf.listValidTypes();
//			
//			boolean found = false;
//			for(Class<?> oneValidType: listValidTypes){	
//								
//				if(type.isPrimitive() && type.toString().equals(oneValidType.toString()))
//					found = true;
//				
////				List -> List // String -> String
//				else if(type.isAssignableFrom(oneValidType))				
//					found = true;
//				
////				List -> ArrayList
//				else if(oneValidType.isAssignableFrom(type))
//					found = true;
//				
//			}
//			
//			if(!found){			
//				error = getErrorMessage(classConcrete, 
//										field, 
//										classOfAnnotationInField, 
//										type, 
//										listValidTypes);
//			}
//			
//						
//		}
//		
//		return error;
//	}
//		
//	public String verifyValidAnnotationInMethod(Class<?> classConcrete,
//												Method method,
//												Class<? extends Annotation> classOfAnnotationInMethod, 
//												Class<? extends Annotation> classOfSubAnnotation) {		
//		String error = "";
//		
//		if(classOfAnnotationInMethod.isAnnotationPresent(annotation)
//													&& classOfSubAnnotation.equals(annotation)){			
//			
//			ValidFieldTypes vft = classOfAnnotationInMethod.getAnnotation(annotation);			
//			boolean ignoreWhenNotField = vft.ignoreWhenNotField();
//			
//			if(!ignoreWhenNotField){
//				
//				System.out.println("Verifying in method... ValidFieldTypes");
//				
//			}else{
//				
//				System.out.println("Ignoring in method... ValidFieldTypes");
//				
//			}
//			
//		}		
//		
//		return error;
//	}
	
	
}
