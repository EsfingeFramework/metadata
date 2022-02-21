package net.sf.esfinge.metadata.locate.locators.FindAllMetadata;

import net.sf.esfinge.classmock.ClassMock;
import net.sf.esfinge.classmock.api.IClassWriter;
import net.sf.esfinge.classmock.api.enums.ModifierEnum;
import net.sf.esfinge.metadata.AnnotationReadingException;
import net.sf.esfinge.metadata.factory.LocatorsFactory;
import net.sf.esfinge.metadata.locate.MetadataLocator;
import org.junit.Test;

import java.lang.annotation.Annotation;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class InheritanceLocatorTest {

    @Test
    public  void findMetadataOnInheritance() throws AnnotationReadingException, NoSuchMethodException {



        final Class<? extends Annotation> annotation = ToTestInheritance.class;
        MetadataLocator ml = LocatorsFactory.createLocatorsChain(annotation);
        final IClassWriter interfaceF1 = ClassMock.of("TestInterface");
        interfaceF1.asInterface().annotation(annotation);
        Class<?> f1 = interfaceF1.build();

        final IClassWriter interfaceF2 = ClassMock.of("TestInterfaceWithMethod");
        interfaceF2.asInterface().method("setId").modifiers(ModifierEnum.ABSTRACT).annotation(annotation);
        Class<?> f2 = interfaceF2.build();

        IClassWriter mockC1 = ClassMock.of("TestInheritance");
        mockC1.annotation(annotation);
        Class<?> c1 = mockC1.build();

        assertNotNull(ml.findAllMetadata(c1));

//Creating the class without annotation
        final IClassWriter mockC2 = ClassMock.of("ClassWithoutAnnotation");
        final Class<?> c2 = mockC2.build();

        assertNull(ml.findAllMetadata(c2));
//Creating the class to test annotation on method
        final IClassWriter mockC3 = ClassMock.of("ClassWithAnnotationOnMethod");
        mockC3.method("setId").annotation(annotation);
        Class<?> c3 = mockC3.build();

        assertNotNull(ml.findAllMetadata(c3.getMethod("setId")));
//Creating the class with annotation on superclass
        final IClassWriter mockC4 = ClassMock.of("ClassWithAnnotationOnSuperCLass");
        mockC4.superclass(c1);
        final Class<?> c4 = mockC4.build();
        assertNotNull(ml.findAllMetadata(c4));
//Creating the class with annotation on interface
        final IClassWriter mockC5 = ClassMock.of("ClassWithAnnotationOnInterface");
        mockC5.interfaces(f1);
        final Class<?> c5 = mockC5.build();
        assertNotNull(ml.findAllMetadata(c5));
////Creating the class with annotation on method of superclass
        final IClassWriter mockC6 = ClassMock.of("ClassWithAnnotationOnMethodOfSuperclass");
        mockC6.superclass(c3);
        mockC6.method("setId");
        final Class<?> c6 = mockC6.build();
        assertNotNull(ml.findAllMetadata(c6.getMethod("setId")));
//Creating the class with annotation on method of Interfaces
        final IClassWriter mockC7 = ClassMock.of("ClassWithAnnotationOnMethodOfInterfaces");
        mockC7.interfaces(f2);
        mockC7.method("setId");
        final Class<?> c7 = mockC7.build();
        assertNotNull(ml.findAllMetadata(c7.getMethod("setId")));
    }
}
