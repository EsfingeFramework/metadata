package net.sf.esfinge.metadata.locate.conventions;

import net.sf.esfinge.metadata.locate.conventions.annotations.ClassIsInPackageConvention;
import net.sf.esfinge.metadata.utils.AnnotatedElementUtils;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassIsInPackageConventionVerifier implements ConventionVerifier<ClassIsInPackageConvention>{


    private String regex;
    private String upperCaseRegex;

    @Override
    public void init(ClassIsInPackageConvention conventionAnnotation) {
        regex =conventionAnnotation.value();

        upperCaseRegex = regex;
        String firstLetStr = upperCaseRegex.substring(0, 1);
        String remLetStr = upperCaseRegex.substring(1);
        firstLetStr = firstLetStr.toUpperCase();
        upperCaseRegex = firstLetStr + remLetStr;

    }

    @Override
    public boolean isConventionPresent(AnnotatedElement element) {
            Class<?> clazz = (Class<?>) element;

            String declaredClassPackageName = clazz.getName();
            if(declaredClassPackageName.matches(".*"+ regex +".*") || declaredClassPackageName.matches(".*"+ upperCaseRegex +".*")) {
                return true;
            }

        return false;
    }
}
