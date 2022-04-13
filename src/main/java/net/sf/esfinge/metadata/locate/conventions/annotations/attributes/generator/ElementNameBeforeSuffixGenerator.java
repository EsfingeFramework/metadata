package net.sf.esfinge.metadata.locate.conventions.annotations.attributes.generator;

import net.sf.esfinge.metadata.locate.conventions.annotations.attributes.ElementNameBeforeSuffix;
import net.sf.esfinge.metadata.utils.AnnotatedElementUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;

public class ElementNameBeforeSuffixGenerator implements AtributeConventionValueGenerator{
    @Override
    public Object generateValue(Class<? extends Annotation> mainAnnotation, AnnotatedElement element, Method annotationAtribute, Annotation atributeConvention) {
        ElementNameBeforeSuffix ele = (ElementNameBeforeSuffix)atributeConvention;
        String suffix = ele.suffix();
        String nameBeforeSuffix = AnnotatedElementUtils.getName(element).substring(suffix.length());
        System.out.println(nameBeforeSuffix);
        return nameBeforeSuffix;

    }
}
