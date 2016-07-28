package org.esfinge.metadata.annotation.container;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;
import java.util.Set;

import org.esfinge.metadata.annotation.validator.ValidFieldType;
import org.esfinge.metadata.container.reading.AllFieldsWithReadingProcessor;
import org.esfinge.metadata.container.reading.AllMethodsWithReadingProcessor;
import org.esfinge.metadata.container.reading.AnnotationPropertyReadingProcessor;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@AnnotationReadingConfig(AllFieldsWithReadingProcessor.class)

@ValidFieldType({List.class, Set.class})
public @interface AllFieldsWith {
	Class<? extends Annotation> value();
}
