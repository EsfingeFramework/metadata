package Test.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import net.sf.esfinge.metadata.annotation.finder.SearchInsideAnnotations;


@SearchInsideAnnotations
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodAnnoted {

}
