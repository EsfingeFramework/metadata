package net.sf.esfinge.metadata.locate.conventions.annotations.attributes.generator;

import net.sf.esfinge.metadata.locate.conventions.annotations.attributes.ElementNameAfterPrefix;
import net.sf.esfinge.metadata.locate.conventions.annotations.attributes.generator.AtributeConventionValueGenerator;
import net.sf.esfinge.metadata.utils.AnnotatedElementUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;

public class ElementNameAfterPrefixGenerator implements AtributeConventionValueGenerator {
    @Override
    public Object generateValue(Class<? extends Annotation> mainAnnotation, AnnotatedElement element, Method annotationAtribute, Annotation atributeConvention) {
        ElementNameAfterPrefix ele = (ElementNameAfterPrefix)atributeConvention;
        String prefix = ele.prefix();
        String nameAfterPrefix = AnnotatedElementUtils.getName(element).substring(prefix.length());
        return nameAfterPrefix;
    }
}
