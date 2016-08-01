package org.esfinge.metadata.annotation.container;

import java.util.List;
import java.util.Map;
import java.util.Set;
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
@ValidFieldType({Map.class,List.class,Set.class})
//verificar se a classe do generics da lista possui @ContainerFor(METHOD)
public @interface ProcessMethods {

}
