package net.sf.esfinge.metadata.locate.conventions.annotations.attributes.generator;

import net.sf.esfinge.metadata.locate.conventions.annotations.attributes.ElementName;


import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;

public class ElementNameGenerator implements AtributeConventionValueGenerator{
    @Override
    public Object generateValue(Class<? extends Annotation> mainAnnotation, AnnotatedElement element, Method annotationAtribute, Annotation atributeConvention) {
        ElementName ele = (ElementName)atributeConvention;
        return ele.name();
    }
}
