package org.esfinge.metadata.foo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;

import org.esfinge.metadata.foo.annotation.visibility.ValidFieldTypes;

@ValidFieldTypes(listValidTypes = {String.class, List.class, int.class})
@Retention(RetentionPolicy.RUNTIME)
//@Target(ElementType.FIELD)
public @interface OneAnnotationWithValidFieldTypes {
}
