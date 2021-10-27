package net.sf.esfinge.metadata.locate.conventions;

import net.sf.esfinge.metadata.locate.conventions.annotations.ClassHaveAnnotationConvention;
import net.sf.esfinge.metadata.locate.conventions.annotations.FieldTypeConvention;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassHaveAnnotationConventionVerifier implements ConventionVerifier<ClassHaveAnnotationConvention>{
    private Class<?>[] classAnnotations;


    @Override
    public void init(ClassHaveAnnotationConvention conventionAnnotation) {
        for (int i = 0; i < conventionAnnotation.classAnnotations().length; i++) {
            classAnnotations[i] = conventionAnnotation.classAnnotations()[i];
        }

    }

    @Override
    public boolean isConventionPresent(AnnotatedElement element) {
        if(element instanceof Field) {
            Field field = (Field) element;
            Class<?> fieldDeclaredClass = field.getDeclaringClass();
            Annotation[] classDeclaredAnnotations = fieldDeclaredClass.getDeclaredAnnotations();
            for(int i=0;i< classDeclaredAnnotations.length;i++){
                for(int j=0;j< classAnnotations.length;j++){
                    if(classDeclaredAnnotations[i].getClass().equals(classAnnotations[j].getClass())){
                        return true;
                    }
                }
            }
        }else if (element instanceof Method){
            Method method = (Method) element;
            Class<?> methodDeclaredClass = method.getDeclaringClass();
            Annotation[] classDeclaredAnnotations = methodDeclaredClass.getDeclaredAnnotations();
            for(int i=0;i< classDeclaredAnnotations.length;i++){
                for(int j=0;j< classAnnotations.length;j++){
                    if(classDeclaredAnnotations[i].getClass().equals(classAnnotations[j].getClass())){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
