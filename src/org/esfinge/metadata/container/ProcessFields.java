package org.esfinge.metadata.container;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.esfinge.metadata.container.reading.ProcessFieldsReadingProcessor;
import org.esfinge.metadata.container.reading.ProcessMethodsReadingProcessor;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@AnnotationReadingConfig(ProcessFieldsReadingProcessor.class)
public @interface ProcessFields {

}
