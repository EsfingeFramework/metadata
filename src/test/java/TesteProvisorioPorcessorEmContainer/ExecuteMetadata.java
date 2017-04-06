package TesteProvisorioPorcessorEmContainer;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;

@Retention(RUNTIME)
@ProcessAnnotation(ImplementedInterface.class)
public @interface ExecuteMetadata {

}
