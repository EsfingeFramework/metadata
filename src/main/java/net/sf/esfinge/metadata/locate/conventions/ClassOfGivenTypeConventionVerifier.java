package net.sf.esfinge.metadata.locate.conventions;

import net.sf.esfinge.metadata.locate.conventions.annotations.ClassOfGivenTypeConvention;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

public class ClassOfGivenTypeConventionVerifier implements ConventionVerifier<ClassOfGivenTypeConvention>{
    private Class<?> superClass;
    private boolean canBeSubtype;
    @Override
    public void init(ClassOfGivenTypeConvention conventionAnnotation) {
        superClass = conventionAnnotation.superClass();
        canBeSubtype = conventionAnnotation.canBeSubtype();
    }
    @Override
    public void init(Map<String,String> parameters)  {
        try {
            superClass= Class.forName(parameters.get("superClass"));
            canBeSubtype = Boolean.getBoolean(parameters.get("canBeSubtype"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    @Override
    public boolean isConventionPresent(AnnotatedElement element) {
        if (element instanceof Class<?>) {
            Class<?> clazz = element.getClass();

            if(canBeSubtype){
                return superClass.isAssignableFrom(((Class<?>) element).getSuperclass());
            }else

                return superClass.equals(clazz);
        }
        return false;
    }
}
