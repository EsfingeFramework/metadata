package net.sf.esfinge.metadata.TestAnnotationReader.AnnotationProperty;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Propriedade {
	Class nome();
	
}
