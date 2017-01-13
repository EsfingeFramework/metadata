package net.sf.esfinge.metadata.annotation.container;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;

import net.sf.esfinge.metadata.container.reading.PropertyProcessorsProcessorsReadingProcessorNew;

@Retention(RUNTIME)
@AnnotationReadingConfig(PropertyProcessorsProcessorsReadingProcessorNew.class)


public @interface PropertyProcessorsNew {
	AnnotationPropertyLocation value();
}
