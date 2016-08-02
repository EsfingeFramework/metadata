package org.esfinge.metadata.foo.validator;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.esfinge.metadata.foo.annotation.OneAnnotationWithStaticFieldOnly;
import org.esfinge.metadata.foo.annotation.fieldonly.FinalFieldOnly;
import org.esfinge.metadata.foo.annotation.fieldonly.StaticFieldOnly;
import org.esfinge.metadata.foo.annotation.fieldonly.TransientFieldOnly;
import org.esfinge.metadata.foo.annotation.fieldonly.VolatileFieldOnly;

public class Validator {
	
	public String getErrorMessage(Class<?> classConcrete, Field field, Class<?> annotation, String modifiers_name, String modifiers){			
		return "The field " + field.getName() + " in the " + classConcrete.getSimpleName() 
				+ " is using the @" + annotation.getSimpleName() + " annotation, however it has no " + modifiers_name + " modifier.\n"
				+ "(it has this(these) modifier(s): " + modifiers + " )";		
	}
	
	public String exec(Class<?> classConcrete, Field field, 
						Class<?> classAnnotation, String type){
		String error = "";
		
		String modifiers = Modifier.toString(field.getModifiers());	
		
		if(!modifiers.contains(type)){					
			if(modifiers.equals("")) modifiers = "default";
						
			error = getErrorMessage(classConcrete, field, classAnnotation, type, modifiers);	
		}
		
		return error;
	}
	
	public String validateField(Class<?> classConcrete, Field field){
		String error = "";
					
		Class<? extends Annotation> classOneAnnotation = OneAnnotationWithStaticFieldOnly.class;
		
		if(field.isAnnotationPresent(classOneAnnotation)){			
			Annotation[] annotations = classOneAnnotation.getAnnotations();
			
			for(Annotation annotation: annotations){				
				Class<?> classAnnotationType = annotation.annotationType();
				
				if(classAnnotationType.isAssignableFrom(StaticFieldOnly.class)){								
					error = exec(classConcrete, field, classOneAnnotation, "static");					
				}else if(classAnnotationType.isAssignableFrom(FinalFieldOnly.class)){								
					error = exec(classConcrete, field, classOneAnnotation, "final");					
				}else if(classAnnotationType.isAssignableFrom(TransientFieldOnly.class)){								
					error = exec(classConcrete, field, classOneAnnotation, "transient");					
				}else if(classAnnotationType.isAssignableFrom(VolatileFieldOnly.class)){								
					error = exec(classConcrete, field, classOneAnnotation, "volatile");					
				}
//				else{
//					error = ">>> Invalid Annotation";
//				}
				
			}				
		}
		
		return error;
	}
	
	public boolean validateAnnotationInObject(Object someObject) throws Exception{
		StringBuilder errorsBuilder = new StringBuilder();

		Class<?> classConcrete = someObject.getClass();		
		Field[] declaredFields = classConcrete.getDeclaredFields();
		
		for(Field field: declaredFields){			
			String error = validateField(classConcrete, field);
			
			if(!error.equals(""))						
				errorsBuilder.append(error + "\n");			
		}
		
		String errors = errorsBuilder.toString();
		if(!errors.equals(""))
			throw new Exception(errors);
		
		return true;
	}

}
