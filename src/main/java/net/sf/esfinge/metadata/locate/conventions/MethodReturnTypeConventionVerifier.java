package net.sf.esfinge.metadata.locate.conventions;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;

import net.sf.esfinge.metadata.locate.conventions.annotations.MethodReturnTypeConvention;
public class MethodReturnTypeConventionVerifier implements ConventionVerifier<MethodReturnTypeConvention>{

    private Class<?> returnType;
    private boolean canBeSubtype;
    @Override
    public void init(MethodReturnTypeConvention conventionAnnotation) {

        returnType = conventionAnnotation.returnType();
        canBeSubtype = conventionAnnotation.canBeSubtype();
    }

    @Override
    public boolean isConventionPresent(AnnotatedElement element) {
        if(element instanceof Method){
            Method method = (Method) element;
            if(canBeSubtype){
                    return returnType.isAssignableFrom(method.getReturnType());
            }else{
                    return returnType == method.getReturnType();
            }
        }
        return false;
    }
}
