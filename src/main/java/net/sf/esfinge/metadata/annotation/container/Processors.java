package net.sf.esfinge.metadata.annotation.container;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.sf.esfinge.metadata.annotation.validator.ValidFieldType;
import net.sf.esfinge.metadata.container.reading.ProcessorsReadingProcessor;
import net.sf.esfinge.metadata.container.reading.ReflectionReferenceReadingProcessor;

@Retention(RUNTIME)
@AnnotationReadingConfig(ProcessorsReadingProcessor.class)

public @interface Processors {
	Class<? extends Annotation> value();
}
