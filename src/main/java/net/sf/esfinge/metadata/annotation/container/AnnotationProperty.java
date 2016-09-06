package net.sf.esfinge.metadata.annotation.container;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import net.sf.esfinge.metadata.annotation.validator.ValidFieldType;
import net.sf.esfinge.metadata.container.reading.AnnotationPropertyReadingProcessor;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@AnnotationReadingConfig(AnnotationPropertyReadingProcessor.class)
//Deve validar se o tipo do field eh do mesmo tipo do atributo da anotacao
//@ValidFieldType({String.class})
public @interface AnnotationProperty {
	Class<? extends Annotation> annotation();
	String property() default "value";
}
