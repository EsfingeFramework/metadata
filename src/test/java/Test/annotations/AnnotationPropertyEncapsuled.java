package Test.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import net.sf.esfinge.metadata.annotation.finder.SearchInsideAnnotations;
import net.sf.esfinge.metadata.annotation.finder.SearchOnEnclosingElements;

@Retention(RetentionPolicy.RUNTIME)

@SearchOnEnclosingElements
@SearchInsideAnnotations
@Variavel(nome="dominio")
public @interface AnnotationPropertyEncapsuled {

}
