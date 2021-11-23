package net.sf.esfinge.metadata.locate.conventions.annotations;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
@ClassHaveAnnotationConvention(classAnnotations = {Annotation.class},canBeSubtype = true)
public @interface ClassHaveAnnotation {
}
