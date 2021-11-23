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
            if(canBeSubtype){

                for(int i=0;i<((Field) element).getDeclaringClass().getInterfaces().length;i++){

                    if(((Field) element).getDeclaringClass().getInterfaces()[i].isAssignableFrom(classType)) {
                        return true;
                    }
                }

                return classType.isAssignableFrom(((Field) element).getDeclaringClass().getSuperclass());

            }else{

                return classType.equals(((Field) element).getDeclaringClass().getClass());
            }
        }else if (element instanceof Method){
            if(canBeSubtype){

                for(int i=0;i<((Method) element).getDeclaringClass().getInterfaces().length;i++){

                    if(((Method) element).getDeclaringClass().getInterfaces()[i].isAssignableFrom(classType)) {
                        return true;
                    }
                }

                return classType.isAssignableFrom(((Method) element).getDeclaringClass().getSuperclass());

            }else{

                return classType.equals(((Method) element).getDeclaringClass().getClass());
            }
        }
        return false;
    }
}
