package net.sf.esfinge.container.processor.Field;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface ProcessorAnnotation {
	Class<? extends ProcessorInterface> value();
}
