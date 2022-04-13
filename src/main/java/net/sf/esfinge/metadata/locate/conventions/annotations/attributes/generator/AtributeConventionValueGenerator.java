package net.sf.esfinge.metadata.locate.conventions.annotations.attributes.generator;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;

public interface AtributeConventionValueGenerator {

    public Object generateValue(Class<? extends Annotation> mainAnnotation, AnnotatedElement element, Method annotationAtribute, Annotation atributeConvention);

}
