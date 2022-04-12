package net.sf.esfinge.metadata.locate.conventions;

import net.sf.esfinge.metadata.locate.conventions.annotations.ClassHaveAnnotationConvention;
import net.sf.esfinge.metadata.locate.conventions.annotations.FieldTypeConvention;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ClassHaveAnnotationConventionVerifier implements ConventionVerifier<ClassHaveAnnotationConvention>{
    private Class<?>[] classAnnotations;
    private boolean canBeSubtype;

    @Override
    public void init(ClassHaveAnnotationConvention conventionAnnotation) {
        classAnnotations = new Class<?>[conventionAnnotation.classAnnotations().length];
        for (int i = 0; i < conventionAnnotation.classAnnotations().length; i++) {
            classAnnotations[i] = conventionAnnotation.classAnnotations()[i];
        }
        canBeSubtype = conventionAnnotation.canBeSubtype();

    }
    @Override
    public void init(Map<String,String> parameters) {
        String[] annotations = parameters.get("classAnnotations").split(",");
        classAnnotations = new Class<?>[annotations.length];
        for (int i = 0; i < annotations.length; i++) {
            try {
                classAnnotations[i] = Class.forName(annotations[i]);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        canBeSubtype = Boolean.getBoolean(parameters.get("canBeSubtype"));

    }
    @Override
    public boolean isConventionPresent(AnnotatedElement element) {

        if(element instanceof Field) {

            Field field = (Field) element;
            Class<?> fieldDeclaredClass = field.getDeclaringClass();

            Annotation[] classDeclaredAnnotations = fieldDeclaredClass.getDeclaredAnnotations();
            for(int i=0;i< classDeclaredAnnotations.length;i++){
                for(int j=0;j< classAnnotations.length;j++){
                    if(canBeSubtype){
                        return classAnnotations[j].isAssignableFrom(classDeclaredAnnotations[i].annotationType());
                    }else if(classDeclaredAnnotations[i].annotationType().equals(classAnnotations[j])){
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
                    if(canBeSubtype){
                        return classAnnotations[j].isAssignableFrom(classDeclaredAnnotations[i].annotationType());
                    }else if(classDeclaredAnnotations[i].annotationType().equals(classAnnotations[j])){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
