package net.sf.esfinge.metadata.locate.conventions;

import net.sf.esfinge.metadata.locate.conventions.annotations.MethodExactParamListConvention;


import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class MethodExactParamListConventionVerifier implements ConventionVerifier<MethodExactParamListConvention> {

    private Class<?>[] parameters;

    @Override
    public void init(MethodExactParamListConvention conventionAnnotation) {
        parameters = new Class<?>[conventionAnnotation.parameters().length];
        for (int i = 0; i < conventionAnnotation.parameters().length; i++) {
            parameters[i] = conventionAnnotation.parameters()[i];
        }

    }

    @Override
    public boolean isConventionPresent(AnnotatedElement element) {

        if (element instanceof Method) {
            Method method = (Method) element;
            Parameter[] params = method.getParameters();

            for (int i = 0; i < params.length; i++) {

                for(int j=0;j< parameters.length;j++){
                    if (params[i].getType() != parameters[j]) {
                        return false;
                    }
                }

            }
            return true;
        }
        return false;
    }
}