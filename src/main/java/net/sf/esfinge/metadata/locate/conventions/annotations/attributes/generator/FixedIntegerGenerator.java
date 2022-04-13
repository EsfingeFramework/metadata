package net.sf.esfinge.metadata.locate.conventions.annotations.attributes.generator;

import net.sf.esfinge.metadata.locate.conventions.annotations.attributes.FixedByteValue;
import net.sf.esfinge.metadata.locate.conventions.annotations.attributes.FixedIntegerValue;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;

public class FixedIntegerGenerator implements AtributeConventionValueGenerator{
    @Override
    public Object generateValue(Class<? extends Annotation> mainAnnotation, AnnotatedElement element, Method annotationAtribute, Annotation atributeConvention) {
        FixedIntegerValue ele = (FixedIntegerValue)atributeConvention;
        return ele.value();
    }
}
