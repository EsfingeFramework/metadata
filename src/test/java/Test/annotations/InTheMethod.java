package Test.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import net.sf.esfinge.metadata.annotation.validator.SearchInsideAnnotations;
import net.sf.esfinge.metadata.annotation.validator.SearchOnEnclosingElements;

@Retention(RetentionPolicy.RUNTIME)

@SearchOnEnclosingElements
@SearchInsideAnnotations
@MethodAnnoted
public @interface InTheMethod {

}
