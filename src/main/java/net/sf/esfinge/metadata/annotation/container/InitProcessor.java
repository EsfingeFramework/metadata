package net.sf.esfinge.metadata.annotation.container;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.AnnotatedElement;

import net.sf.esfinge.metadata.container.reading.ElementNameReadingProcessor;
import net.sf.esfinge.metadata.container.reading.InitProcessorReadingProcessor;

@Retention(RetentionPolicy.RUNTIME)
public @interface InitProcessor {
}
