package net.sf.esfinge.metadata.container.reading.PropertyProcessorsProcessorsTests.container.reading.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import javax.persistence.EmbeddedId;
import javax.persistence.Id;

public class BeanUtils {

    public static String getIdProp(Class c){
        for(Method m : c.getMethods()){
            boolean isGetter = m.getName().startsWith("get");
            boolean noParameters = (m.getParameterTypes().length == 0);
            boolean notGetClass = !m.getName().equals("getClass");
            if (isGetter && noParameters && notGetClass) {
                boolean hasIdMethod = m.isAnnotationPresent(Id.class) || m.isAnnotationPresent(EmbeddedId.class);
                String fieldName = acessorToProperty(m.getName());
                boolean hasIdField = isIdField(c, fieldName);
                if(hasIdMethod || hasIdField){
                    return fieldName;
                }
            }
        }
        return null;
    }

    private static boolean isIdField(Class c, String fieldName) {
        boolean hasIdField = false;
        try {
            Field f = c.getDeclaredField(fieldName);
            hasIdField = f.isAnnotationPresent(Id.class) || f.isAnnotationPresent(EmbeddedId.class);
        } catch (Exception e) {
            hasIdField = false;
        }
        return hasIdField;
    }

    public static Object getProperty(Object bean, String property) {
        try {
            if(property.indexOf(".")>=0){
                Object subBean = getProperty(bean, property.substring(0,property.indexOf(".")));
                if(subBean == null)
                    return null;
                String newProperty = property.substring(property.indexOf(".")+1);
                return getProperty(subBean, newProperty);
            }
            Method method = retrieveMethod(bean, property);
            return method.invoke(bean,new Object[]{});
        } catch (Exception e) {
            throw new RuntimeException("Can't get property "+property+" in the class "+ bean.getClass().getName(),e);
        }
    }

    private static Method retrieveMethod(Object bean, String property)
            throws NoSuchMethodException {
        Method method = null;
        try {
            method = bean.getClass().getMethod(propertyToGetter(property),new Class[]{});
        } catch (NoSuchMethodException e) {
            method = bean.getClass().getMethod(propertyToGetter(property,true),new Class[]{});
        }
        return method;
    }

    public static String acessorToProperty(String acessorName){
        int initLetter = 3;
        if(acessorName.startsWith("is")){
            initLetter = 2;
        }
        if(Character.isLowerCase(acessorName.charAt(initLetter+1)))
            return acessorName.substring(initLetter,initLetter+1).toLowerCase()+acessorName.substring(initLetter+1);
        else
            return acessorName.substring(initLetter);
    }

    public static String propertyToGetter(String propertieName) {
        return propertyToGetter(propertieName, false);
    }

    public static String propertyToGetter(String propertieName, boolean isBoolean) {
        if(isBoolean)
            return "is"+propertieName.substring(0,1).toUpperCase()+propertieName.substring(1);
        return "get"+propertieName.substring(0,1).toUpperCase()+propertieName.substring(1);
    }

    public static boolean isAnnotationPresentInProperty(String propName, Class clazz, Class annotation){
        try {
            Field f = clazz.getDeclaredField(propName);
            Method m = clazz.getMethod(propertyToGetter(propName));
            return f.isAnnotationPresent(annotation) || m.isAnnotationPresent(annotation);
        } catch (Exception e) {
            throw new RuntimeException("Cannot access property "+propName+" on class "+clazz.getName(),e);
        }
    }

}
