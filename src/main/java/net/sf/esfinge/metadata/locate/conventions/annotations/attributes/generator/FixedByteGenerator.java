package net.sf.esfinge.metadata.locate.conventions.annotations.attributes.generator;

import net.sf.esfinge.metadata.locate.conventions.annotations.attributes.FixedBooleanValue;
import net.sf.esfinge.metadata.locate.conventions.annotations.attributes.FixedByteValue;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;

public class FixedByteGenerator implements AtributeConventionValueGenerator{
    @Override
    public Object generateValue(Class<? extends Annotation> mainAnnotation, AnnotatedElement element, Method annotationAtribute, Annotation atributeConvention) {
        FixedByteValue ele = (FixedByteValue)atributeConvention;
        return ele.value();
    }
}
