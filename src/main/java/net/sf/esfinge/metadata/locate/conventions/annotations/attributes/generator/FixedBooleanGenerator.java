package net.sf.esfinge.metadata.locate.conventions.annotations.attributes.generator;

import net.sf.esfinge.metadata.locate.conventions.annotations.attributes.ElementNameAfterPrefix;
import net.sf.esfinge.metadata.locate.conventions.annotations.attributes.FixedBooleanValue;
import net.sf.esfinge.metadata.utils.AnnotatedElementUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;

public class FixedBooleanGenerator implements AtributeConventionValueGenerator {
    @Override
    public Object generateValue(Class<? extends Annotation> mainAnnotation, AnnotatedElement element, Method annotationAtribute, Annotation atributeConvention) {
        FixedBooleanValue ele = (FixedBooleanValue)atributeConvention;
        return ele.value();
    }
}
