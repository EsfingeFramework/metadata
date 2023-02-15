package net.sf.esfinge.metadata.container.reading.PropertyProcessorsProcessorsTests.container.reading.annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;

import net.sf.esfinge.metadata.container.reading.PropertyProcessorsProcessorsTests.container.reading.utils.BeanUtils;
import net.sf.esfinge.metadata.AnnotationReadingException;
import net.sf.esfinge.metadata.AnnotationValidationException;
import net.sf.esfinge.metadata.container.AnnotationReadingProcessor;
import net.sf.esfinge.metadata.container.ContainerTarget;


public class AssociateReadingProcessor implements AnnotationReadingProcessor {

    Associate annot;
    Field field;
    @Override
    public void initAnnotation(Annotation an, AnnotatedElement element) throws AnnotationValidationException {

        this.field = (Field) element;
        annot = (Associate) an;

    }

    @Override
    public void read(AnnotatedElement elementWithMetadata, Object container, ContainerTarget target)
            throws AnnotationReadingException {

        Field fieldElement = (Field) elementWithMetadata;

        Class clazz = fieldElement.getDeclaringClass();

        try {
            Method method =(Method) clazz.getMethod(BeanUtils.propertyToGetter(fieldElement.getName()));

            if(method.isAnnotationPresent(annot.value()[0])	&& method.isAnnotationPresent(annot.value()[1]))
            {

                ParameterizedType parametr= (ParameterizedType) fieldElement.getGenericType();

                org.apache.commons.beanutils.BeanUtils.setProperty(container, field.getName(), parametr.getActualTypeArguments()[0]);
            }
            else
            {
                org.apache.commons.beanutils.BeanUtils.setProperty(container, field.getName(), method.getReturnType());
            }


        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}