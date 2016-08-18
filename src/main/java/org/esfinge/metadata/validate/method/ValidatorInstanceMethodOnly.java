package org.esfinge.metadata.validate.method;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.esfinge.metadata.AnnotationValidationException;
import org.esfinge.metadata.AnnotationValidator;

public class ValidatorInstanceMethodOnly implements AnnotationValidator{
	
	@Override
	public void initialize(Annotation self) {		
	}

	@Override
	public void validate(Annotation toValidate, 
							AnnotatedElement annotated)
									throws AnnotationValidationException {		
		
		if(annotated instanceof Method){			
			Method method = (Method) annotated;						
			Class<?> classConcrete = method.getDeclaringClass();
						
			String modifiers = Modifier.toString(method.getModifiers());
						
			if(modifiers.contains("static")){
				String error = getErrorMessage(classConcrete, 
												method,
												toValidate.annotationType(), 
												modifiers);	
				throw new AnnotationValidationException(error);
			}			
		}
			
	}	

	private String getErrorMessage(Class<?> classConcrete, 
									Method method,			
									Class<?> classOfAnnotationInField,
									String modifiers) {		

		return "The method " + method.getName() + " in the " + classConcrete.getSimpleName() 
				+ " is using the @" + classOfAnnotationInField.getSimpleName() 
				+ " annotation, however it has static modifier.\n"
				+ "(it has this(these) modifier(s): " + modifiers + " )";		
	}	
	
}
