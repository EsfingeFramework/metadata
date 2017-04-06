package TesteProvisorioPorcessorEmContainer;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;


@Retention(RUNTIME)
@Target(ANNOTATION_TYPE)
public @interface ProcessAnnotation {
	Class<? extends InterfaceCustom> value();

}
