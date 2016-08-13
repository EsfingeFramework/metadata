package org.esfinge.metadata.validate.method;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.esfinge.metadata.AnnotationValidationException;
import org.esfinge.metadata.AnnotationValidator;

public class ValidatorInstanceMethodOnly implements AnnotationValidator{
	
	@Override
	public void initialize(Annotation self) {	
//		InstanceFieldOnly instanceFieldOnly = (InstanceFieldOnly) self;		
	}

	@Override
	public void validate(Annotation toValidate, 
							AnnotatedElement annotated)
									throws AnnotationValidationException {		
		
		if(annotated instanceof Field){			
			Field field = (Field) annotated;						
			Class<?> classConcrete = field.getDeclaringClass();
						
			String modifiers = Modifier.toString(field.getModifiers());
						
			if(modifiers.contains("static")){
				String error = getErrorMessage(classConcrete, 
												field,
												toValidate.annotationType(), 
												modifiers);	
				throw new AnnotationValidationException(error);
			}			
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
	
}
