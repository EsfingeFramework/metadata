package org.esfinge.metadata.annotation.container;

import java.util.List;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.esfinge.metadata.annotation.validator.ValidFieldType;
import org.esfinge.metadata.container.reading.AnnotationPropertyReadingProcessor;
import org.esfinge.metadata.container.reading.ProcessMethodsReadingProcessor;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@AnnotationReadingConfig(ProcessMethodsReadingProcessor.class)
@ValidFieldType({List.class})
public @interface ProcessMethods {

}
