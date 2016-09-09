package net.sf.esfinge.metadata.annotation.container;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.AnnotatedElement;

import net.sf.esfinge.metadata.container.reading.ElementNameReadingProcessor;

@Retention(RetentionPolicy.RUNTIME)
public @interface InitProcessor {
}
