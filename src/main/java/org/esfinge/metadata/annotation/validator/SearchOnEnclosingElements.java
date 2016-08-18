/*-> se esta anotacao estiver presente, a busca deve ser feita hierarquicamente acima do elemento informado */
package org.esfinge.metadata.annotation.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
public @interface SearchOnEnclosingElements {
}
