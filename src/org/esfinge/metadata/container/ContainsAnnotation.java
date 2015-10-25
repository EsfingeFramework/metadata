package org.esfinge.metadata.container;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ContainsAnnotation {
	Class<? extends Annotation> value();
}
