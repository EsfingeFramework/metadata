package net.sf.esfinge.metadata.annotation.container;

import java.lang.annotation.*;

import net.sf.esfinge.metadata.annotation.validator.ValidFieldType;
import net.sf.esfinge.metadata.container.reading.ContainsAnnotationReadingProcessor;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@AnnotationReadingConfig(ContainsAnnotationReadingProcessor.class)
@ValidFieldType({Boolean.class,boolean.class})
public @interface ContainsAnnotation {
	Class<? extends Annotation> value();
}
