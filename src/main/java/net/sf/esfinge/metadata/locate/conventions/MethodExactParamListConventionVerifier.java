package net.sf.esfinge.metadata.locate.conventions;

import net.sf.esfinge.metadata.locate.conventions.annotations.MethodExactParamListConvention;


import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Map;

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
    public void init(Map<String,String> parameters)  {
        String[] annotations = parameters.get("parameters").split(",");
        this.parameters = new Class<?>[annotations.length];
        for(int i=0;i< annotations.length;i++){
            try {
                this.parameters[i] = Class.forName(annotations[i]);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }


    }
    @Override
    public boolean isConventionPresent(AnnotatedElement element) {

        if (element instanceof Method) {
            Method method = (Method) element;
            Parameter[] params = method.getParameters();
            if(params.length!= parameters.length)
                return false;
            for (int i = 0; i < params.length; i++) {
                    if (params[i].getType() != parameters[i]) {
                        return false;
                    }


            }
            return true;
        }
        return false;
    }
}