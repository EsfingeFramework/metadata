package net.sf.esfinge.metadata.annotation.validator.field;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

import net.sf.esfinge.metadata.annotation.validator.SearchInsideAnnotations;
import net.sf.esfinge.metadata.annotation.validator.SearchOnEnclosingElements;


@SearchInsideAnnotations
@SearchOnEnclosingElements
@ValidFieldTypes(listValidTypes = {String.class, List.class, int.class})
@Retention(RetentionPolicy.RUNTIME)
//@Target(ElementType.FIELD)
public @interface OneAnnotationWithValidFieldTypes {
}
