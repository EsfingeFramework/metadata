package net.sf.esfinge.metadata.annotation.container;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import net.sf.esfinge.metadata.annotation.validator.ValidFieldType;
import net.sf.esfinge.metadata.container.reading.ElementNameReadingProcessor;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@AnnotationReadingConfig(ElementNameReadingProcessor.class)
@ValidFieldType({String.class})
public @interface ElementName {
	
}
