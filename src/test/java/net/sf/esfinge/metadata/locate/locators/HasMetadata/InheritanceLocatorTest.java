package net.sf.esfinge.metadata.locate.locators.HasMetadata;

import net.sf.esfinge.classmock.ClassMock;
import net.sf.esfinge.classmock.api.IClassWriter;
import net.sf.esfinge.classmock.api.enums.ModifierEnum;
import net.sf.esfinge.metadata.AnnotationReadingException;
import net.sf.esfinge.metadata.factory.LocatorsFactory;
import net.sf.esfinge.metadata.locate.MetadataLocator;
import org.junit.Test;

import java.lang.annotation.Annotation;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class InheritanceLocatorTest {

    @Test
    public void hasMetadataOnInheritance() throws AnnotationReadingException, NoSuchMethodException {



        final Class<? extends Annotation> annotation = ToTestInheritance.class;

        final IClassWriter interfaceF1 = ClassMock.of("TestInterface34567890");


        interfaceF1.asInterface().annotation(annotation);

         Class<?> f1 = interfaceF1.build();

        final IClassWriter interfaceF2 = ClassMock.of("TestInterfaceWithMethod333322");
        interfaceF2.asInterface().method("setId").modifiers(ModifierEnum.ABSTRACT).annotation(annotation);
        Class<?> f2 = interfaceF2.build();

        MetadataLocator ml = LocatorsFactory.createLocatorsChain(annotation);

        IClassWriter mockC1 = ClassMock.of("TestInheritance444333222");
        mockC1.annotation(annotation);
        Class<?> c1 = mockC1.build();

        assertTrue(ml.hasMetadata(c1, annotation));


//Creating the class without annotation

        final IClassWriter mockC2 = ClassMock.of("ClassWithoutAnnotation");
        final Class<?> c2 = mockC2.build();

        assertFalse(ml.hasMetadata(c2, annotation));


//Creating the class to test annotation on method

        final IClassWriter mockC3 = ClassMock.of("ClassWithAnnotationOnMethod876532");
        mockC3.method("setId").annotation(annotation);
        Class<?> c3 = mockC3.build();

        assertTrue(ml.hasMetadata(c3.getMethod("setId"), annotation));

//Creating the class with annotation on superclass
        final IClassWriter mockC4 = ClassMock.of("ClassWithAnnotationOnSuperCLass776665");
        mockC4.superclass(c1);
        final Class<?> c4 = mockC4.build();
        assertTrue(ml.hasMetadata(c4, annotation));
//Creating the class with annotation on interface
        final IClassWriter mockC5 = ClassMock.of("ClassWithAnnotationOnInterface122222");
        mockC5.interfaces(f1);
        final Class<?> c5 = mockC5.build();
        assertTrue(ml.hasMetadata(c5, annotation));
////Creating the class with annotation on method of superclass
        final IClassWriter mockC6 = ClassMock.of("ClassWithAnnotationOnMethodOfSuperclass4545");
        mockC6.superclass(c3);
        mockC6.method("setId");
        final Class<?> c6 = mockC6.build();
        assertTrue(ml.hasMetadata(c6.getMethod("setId"),annotation));

//Creating the class with annotation on method of Interfaces
        final IClassWriter mockC7 = ClassMock.of("ClassWithAnnotationOnMethodOfInterfaces6666789");
        mockC7.interfaces(f2);
        mockC7.method("setId");
        final Class<?> c7 = mockC7.build();

        assertTrue(ml.hasMetadata(c7.getMethod("setId"), annotation));
    }
}
