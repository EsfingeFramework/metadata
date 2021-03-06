package net.sf.esfinge.metadata.validate.field;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;

import net.sf.esfinge.metadata.AnnotationValidationException;
import net.sf.esfinge.metadata.AnnotationValidator;
import net.sf.esfinge.metadata.annotation.validator.field.ValidFieldTypes;

public class ValidatorValidFieldTypes implements AnnotationValidator {
	
	private Class<?>[] listValidTypes = {};
	
	@Override
	public void initialize(Annotation self) {		
		ValidFieldTypes vft = (ValidFieldTypes) self;		
		listValidTypes = vft.listValidTypes();				
	}

	@Override
	public void validate(Annotation toValidate, 
							AnnotatedElement annotated)
									throws AnnotationValidationException {
		
		if(annotated instanceof Field){			
			Field field = (Field) annotated;						
			Class<?> classConcrete = field.getDeclaringClass(); 
						
			Class<?> type = field.getType();
						
			if(!isTypeValid(type)){			
				String error = getErrorMessage(classConcrete, 
												field, 
												toValidate.annotationType(), 
												type, 
												listValidTypes);				
				throw new AnnotationValidationException(error);
			}			
		}
		
	}

	private boolean isTypeValid(Class<?> type) {
		
		for(Class<?> oneValidType: listValidTypes){			
			if(oneValidType.isAssignableFrom(type))
				return true;			
		}
		
		return false;
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
	
}
