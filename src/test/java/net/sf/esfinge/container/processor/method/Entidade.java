package net.sf.esfinge.container.processor.method;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import net.sf.esfinge.metadata.annotation.validator.SearchInsideAnnotations;
import net.sf.esfinge.metadata.annotation.validator.SearchOnEnclosingElements;


@Retention(RetentionPolicy.RUNTIME)
@SearchOnEnclosingElements
@SearchInsideAnnotations
@ProcessorAnnotation(DominioSegundo.class)
public @interface Entidade {
	
}
