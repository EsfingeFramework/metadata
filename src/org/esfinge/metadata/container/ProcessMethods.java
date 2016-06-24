package org.esfinge.metadata.container;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.esfinge.metadata.container.reading.AnnotationPropertyReadingProcessor;
import org.esfinge.metadata.container.reading.ProcessMethodsReadingProcessor;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@AnnotationReadingConfig(ProcessMethodsReadingProcessor.class)
public @interface ProcessMethods {

}
