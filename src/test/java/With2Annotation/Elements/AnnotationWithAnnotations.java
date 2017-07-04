package With2Annotation.Elements;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;

import net.sf.esfinge.metadata.annotation.finder.SearchInsideAnnotations;

@Retention(RUNTIME)
@Annotation1("teste")
@Annotation2("teste2")
@SearchInsideAnnotations
public @interface AnnotationWithAnnotations {

}
