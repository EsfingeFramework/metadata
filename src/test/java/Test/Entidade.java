package Test;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import Test.annotations.Interna;
import net.sf.esfinge.metadata.annotation.validator.SearchInsideAnnotations;

@Retention(RetentionPolicy.RUNTIME)

@SearchInsideAnnotations
@Interna
public @interface Entidade {

}
