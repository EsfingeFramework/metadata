package net.sf.esfinge.metadata.locate.conventions.classmock;

import net.sf.esfinge.classmock.ClassMock;
import net.sf.esfinge.classmock.api.*;
import net.sf.esfinge.metadata.AnnotationReadingException;
import net.sf.esfinge.metadata.factory.LocatorsFactory;
import net.sf.esfinge.metadata.locate.MetadataLocator;
import net.sf.esfinge.metadata.locate.conventions.annotations.HasMethodType;


import java.lang.annotation.Annotation;
import java.util.ArrayList;

import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;


public class ClassMockMethodParamOfTypeTest {
    @Test

    public  void conventionsWithMapping() throws AnnotationReadingException, NoSuchMethodException{

        final Class<? extends Annotation> annotation =  HasMethodType.class;

        MetadataLocator ml = LocatorsFactory.createLocatorsChain(annotation);

//Creating the class with annotation

        final IClassWriter mockC1 = ClassMock.of("ClassWithAnnotation");
        mockC1.annotation(annotation);
        mockC1.method("setId").parameter("id",Integer.class);
        final Class<?> c1 = mockC1.build();
        assertTrue(ml.hasMetadata(c1.getDeclaredMethod("setId",Integer.class), annotation));
        //System.out.print(ml.hasMetadata(c1.getDeclaredMethod("setId"), annotation));
//Creating the class without prefix and without annotation

        final IClassWriter mockC2 = ClassMock.of("ClassWithoutAnnotation");
        mockC2.method("setId").parameter("id",String.class);
        final Class<?> c2 = mockC2.build();
        assertFalse(ml.hasMetadata(c2.getDeclaredMethod("setId",String.class), annotation));
       // System.out.print(ml.hasMetadata(c2.getDeclaredMethod("setId",String.class), annotation));
//Creating the class with prefix and without annotation

        final IClassWriter mockC3 = ClassMock.of("MethodHasParameterOfTypeWithoutAnnotation");
        IMethodWriter m1 = mockC3.method("setId");
        m1.parameter("id", ArrayList.class);
        m1.parameter("nome",String.class);
        final Class<?> c3 = mockC3.build();
        assertTrue(ml.hasMetadata(c3.getDeclaredMethod("setId",ArrayList.class,String.class), annotation));
       // System.out.print(ml.hasMetadata(c3.getDeclaredMethod("setId",ArrayList.class,String.class), annotation));
    }
}
