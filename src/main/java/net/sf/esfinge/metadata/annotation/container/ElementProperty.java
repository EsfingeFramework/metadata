package net.sf.esfinge.metadata.annotation.container;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import net.sf.esfinge.metadata.container.reading.ElementPropertyReadingProcessorNew;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@AnnotationReadingConfig(ElementPropertyReadingProcessorNew.class)
public @interface ElementProperty {
	AnnotationPropertyLocation property() default AnnotationPropertyLocation.ALL;	
}
