package net.sf.esfinge.metadata.annotation.container;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import net.sf.esfinge.metadata.annotation.validator.ValidFieldType;
import net.sf.esfinge.metadata.container.reading.ReflectionReferenceReadingProcessor;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@AnnotationReadingConfig(ReflectionReferenceReadingProcessor.class)
@ValidFieldType({Class.class})
//Verificar se o tipo do field condiz com o valor do @ContainerFor
//METHOD -> Method
//CLASS -> Class
//FIELD -> Field
//ALL -> Method, Class, Field 
public @interface ReflectionReference {
	
}
