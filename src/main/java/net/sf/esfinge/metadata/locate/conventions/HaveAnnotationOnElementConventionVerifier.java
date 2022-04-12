package net.sf.esfinge.metadata.locate.conventions;

import net.sf.esfinge.metadata.locate.conventions.annotations.ClassHaveAnnotationConvention;
import net.sf.esfinge.metadata.locate.conventions.annotations.HaveAnnotationOnElementConvention;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

public class HaveAnnotationOnElementConventionVerifier implements ConventionVerifier<HaveAnnotationOnElementConvention>{
    private Class<? extends Annotation> annotationClass;



    @Override
    public void init(HaveAnnotationOnElementConvention conventionAnnotation) {

        annotationClass=conventionAnnotation.annotationClass();

    }
    @Override
    public void init(Map<String,String> parameters)  {
        try {
            annotationClass= (Class<? extends Annotation>) Class.forName(parameters.get("annotationClass"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    @Override
    public boolean isConventionPresent(AnnotatedElement element) {
        return element.isAnnotationPresent(annotationClass);

    }
}
