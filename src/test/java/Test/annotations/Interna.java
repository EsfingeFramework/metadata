package Test.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import net.sf.esfinge.metadata.annotation.validator.SearchInsideAnnotations;

@SearchInsideAnnotations
@Retention(RetentionPolicy.RUNTIME)
public @interface Interna {

}
