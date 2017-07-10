package net.sf.esfinge.metadata.annotation.container;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import net.sf.esfinge.metadata.annotation.validator.ValidFieldType;
import net.sf.esfinge.metadata.container.reading.ReflectionReferenceReadingProcessor;
import net.sf.esfinge.metadata.annotation.finder.SearchOnEnclosingElements;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@AnnotationReadingConfig(ReflectionReferenceReadingProcessor.class)
@ValidFieldType({Class.class,Field.class,Method.class})
@SearchOnEnclosingElements

public @interface ReflectionReference {
	
}
