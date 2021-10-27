package net.sf.esfinge.metadata.locate.conventions;

import net.sf.esfinge.metadata.locate.conventions.annotations.ClassHaveTypeConvention;


import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassHaveTypeConventionVerifier implements ConventionVerifier<ClassHaveTypeConvention>{


    private Class<?> classType;
    private boolean canBeSubtype;
    @Override
    public void init(ClassHaveTypeConvention conventionAnnotation) {
        classType = conventionAnnotation.classType();
        canBeSubtype = conventionAnnotation.canBeSubtype();
    }

    @Override
    public boolean isConventionPresent(AnnotatedElement element) {
        if (element instanceof Field) {
            Class<?> fieldType = ((Field) element).getDeclaringClass();
            if(canBeSubtype){
                return classType.isAssignableFrom(fieldType);
            }else{
                return classType.equals(fieldType);
            }

        }else if (element instanceof Method){
            Class<?> methodType = ((Method) element).getDeclaringClass();
            if(canBeSubtype){
                return classType.isAssignableFrom(methodType);
            }else{
                return classType.equals(methodType);
            }
        }
        return false;
    }
}
