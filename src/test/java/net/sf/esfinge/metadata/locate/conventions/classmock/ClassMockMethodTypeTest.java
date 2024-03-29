package net.sf.esfinge.metadata.locate.conventions.classmock;

import net.sf.esfinge.classmock.ClassMock;
import net.sf.esfinge.classmock.api.*;
import net.sf.esfinge.classmock.api.enums.LocationEnum;
import net.sf.esfinge.classmock.api.enums.ModifierEnum;
import net.sf.esfinge.classmock.api.enums.VisibilityEnum;
import net.sf.esfinge.classmock.imp.MethodImp;
import net.sf.esfinge.metadata.AnnotationReadingException;
import net.sf.esfinge.metadata.factory.LocatorsFactory;
import net.sf.esfinge.metadata.locate.MetadataLocator;
import net.sf.esfinge.metadata.locate.conventions.annotations.HasMethodType;
import net.sf.esfinge.metadata.locate.conventions.annotations.MethodTypeConvention;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ClassMockMethodTypeTest {
    public static void main(String[] args) throws NoSuchMethodException {

        final Class<? extends Annotation> annotation =  HasMethodType.class;



//Locator

        MetadataLocator ml = null;
        try {
            ml = LocatorsFactory.createLocatorsChain(annotation);
        } catch (AnnotationReadingException e) {
            e.printStackTrace();
        }


//Creating the class with annotation

        final IClassWriter mockC1 = ClassMock.of("ClassWithAnnotation");

        mockC1.method("setId").annotation(annotation);
        final Class<?> c1 = mockC1.build();

        //System.out.println("result for c1 "+ml.hasMetadata(c1.getMethod("setId"), annotation));




//Creating the class without prefix and without annotation

        final IClassWriter mockC2 = ClassMock.of("ClassWithoutAnnotation");
        mockC2.method("setId").parameter("id",String.class);
        final Class<?> c2 = mockC2.build();
        //System.out.println("result for c2 "+ml.hasMetadata(c2.getMethod("setId",String.class), annotation));



//Creating the class with prefix and without annotation

        final IClassWriter mockC3 = ClassMock.of("MethodHasParameterOfTypeWithoutAnnotation");
        mockC3.method("setId").parameter("id",Integer.class);
        mockC3.method("getChildren").parameter("children", ArrayList.class);
        final Class<?> c3 = mockC3.build();
        //System.out.println("result for c3 "+ml.hasMetadata(c3.getMethod("getChildren",ArrayList.class), annotation));
    }
}
