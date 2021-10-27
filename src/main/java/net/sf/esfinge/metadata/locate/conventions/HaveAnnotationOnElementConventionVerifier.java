package net.sf.esfinge.metadata.locate.conventions;

import net.sf.esfinge.metadata.locate.conventions.annotations.ClassHaveAnnotationConvention;
import net.sf.esfinge.metadata.locate.conventions.annotations.HaveAnnotationOnElementConvention;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class HaveAnnotationOnElementConventionVerifier implements ConventionVerifier<HaveAnnotationOnElementConvention>{
    private Class<?> annotationClass;
    private Class<?> elementClass;


    @Override
    public void init(HaveAnnotationOnElementConvention conventionAnnotation) {
        elementClass = conventionAnnotation.elementClass();
        annotationClass=conventionAnnotation.annotationClass();

    }

    @Override
    public boolean isConventionPresent(AnnotatedElement element) {
        if(elementClass==((Field) element).getClass()){
            Annotation[] fieldAnnotations = ((Field) element).getDeclaredAnnotations();
            for(int i=0;i<fieldAnnotations.length;i++){
                if(fieldAnnotations[i].getClass()==annotationClass){
                    return true;
                }
            }
            return false;
        }else if (elementClass==((Method) element).getClass()){
            Annotation[] methodAnnotations = ((Method) element).getDeclaredAnnotations();
            for(int i=0;i<methodAnnotations.length;i++){
                if(methodAnnotations[i].getClass()==annotationClass){
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}
