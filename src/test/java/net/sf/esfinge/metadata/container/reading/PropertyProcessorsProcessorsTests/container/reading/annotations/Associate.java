package net.sf.esfinge.metadata.container.reading.PropertyProcessorsProcessorsTests.container.reading.annotations;


import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import net.sf.esfinge.metadata.annotation.container.AnnotationReadingConfig;
import net.sf.esfinge.metadata.container.reading.ReflectionReferenceReadingProcessor;

@Retention(RUNTIME)
@Target(FIELD)
@AnnotationReadingConfig(AssociateReadingProcessor.class)
public @interface Associate {
    Class<? extends Annotation>[] value() default {};
}
