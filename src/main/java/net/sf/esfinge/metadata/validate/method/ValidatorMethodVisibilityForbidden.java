package net.sf.esfinge.metadata.validate.method;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import net.sf.esfinge.metadata.AnnotationValidationException;
import net.sf.esfinge.metadata.AnnotationValidator;
import net.sf.esfinge.metadata.annotation.validator.method.MethodVisibilityForbidden;

public class ValidatorMethodVisibilityForbidden implements AnnotationValidator {
	
	private String visibility = "";
	
	@Override
	public void initialize(Annotation self) {		
		MethodVisibilityForbidden mvf = (MethodVisibilityForbidden) self;		
		visibility = mvf.itCannotHaveThisVisibility();	
	}

	@Override
	public void validate(Annotation toValidate, 
							AnnotatedElement annotated)
									throws AnnotationValidationException {
		
		if(annotated instanceof Method){			
			Method method = (Method) annotated;						
			Class<?> classConcrete = method.getDeclaringClass();  // ex.: Person.class
						
			String modifiers = Modifier.toString(method.getModifiers());
			
			if(visibility.equals("default") || visibility.equals("")){					
				if( !( modifiers.contains("public") || modifiers.contains("private") || modifiers.contains("protected") ) ){						
					String error = getErrorMessage(classConcrete, method, 
													toValidate.annotationType(), 
													modifiers + " default", 
													"default");	
					throw new AnnotationValidationException(error);
				}
			} else {								
				if(modifiers.contains(visibility)){
					String error = getErrorMessage(classConcrete, method, 
													toValidate.annotationType(), 
													modifiers, 
													visibility);
					throw new AnnotationValidationException(error);
				}
			}			
		}	
		
	}
			
	private String getErrorMessage(Class<?> classConcrete, 
									Method method,			
									Class<? extends Annotation> classOfAnnotationInField,
									String modifiers,
									String visibility) {		
		
		return "The method " + method.getName() + " in the " + classConcrete.getSimpleName() 
				+ " is using the @" + classOfAnnotationInField.getSimpleName() 
				+ " annotation, with this(these) modifier(s): " + modifiers 
				+ ", however it is forbidden to use this: " + visibility + ".\n";
	}
	
}
