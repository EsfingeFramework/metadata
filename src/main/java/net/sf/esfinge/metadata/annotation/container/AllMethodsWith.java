package net.sf.esfinge.metadata.annotation.container;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.sf.esfinge.metadata.annotation.validator.ValidFieldType;
import net.sf.esfinge.metadata.container.reading.AllMethodsWithReadingProcessor;
import net.sf.esfinge.metadata.container.reading.AnnotationPropertyReadingProcessor;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@AnnotationReadingConfig(AllMethodsWithReadingProcessor.class)

@ValidFieldType({List.class, Set.class, Map.class})
public @interface AllMethodsWith {
	Class<? extends Annotation> value();
}
