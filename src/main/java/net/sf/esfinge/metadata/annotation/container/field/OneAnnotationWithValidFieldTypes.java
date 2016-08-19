package net.sf.esfinge.metadata.annotation.container.field;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;

import net.sf.esfinge.metadata.annotation.validator.field.ValidFieldTypes;

@ValidFieldTypes(listValidTypes = {String.class, List.class, int.class})
@Retention(RetentionPolicy.RUNTIME)
//@Target(ElementType.FIELD)
public @interface OneAnnotationWithValidFieldTypes {
}
