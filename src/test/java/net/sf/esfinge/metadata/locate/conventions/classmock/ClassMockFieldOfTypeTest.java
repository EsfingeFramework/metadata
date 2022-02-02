package net.sf.esfinge.metadata.locate.conventions.classmock;

import net.sf.esfinge.classmock.ClassMock;
import net.sf.esfinge.classmock.api.IClassWriter;
import net.sf.esfinge.metadata.AnnotationReadingException;
import net.sf.esfinge.metadata.factory.LocatorsFactory;
import net.sf.esfinge.metadata.locate.MetadataLocator;

import net.sf.esfinge.metadata.locate.conventions.annotations.HasFieldType;


import java.lang.annotation.Annotation;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClassMockFieldOfTypeTest {

    @Test
    public  void conventionsWithMapping() throws AnnotationReadingException, NoSuchFieldException{

        final Class<? extends Annotation> annotation =  HasFieldType.class;



//Locator

        MetadataLocator ml = LocatorsFactory.createLocatorsChain(annotation);



//Creating the class with annotation

        final IClassWriter mockC1 = ClassMock.of("ClassWithAnnotation");
        mockC1.field("id");
        mockC1.annotation(annotation);
        final Class<?> c1 = mockC1.build();
        assertTrue(ml.hasMetadata(c1, annotation));
        //System.out.println(ml.hasMetadata(c1.getDeclaredField("id"), annotation));



//Creating the class without prefix and without annotation

        final IClassWriter mockC2 = ClassMock.of("ClassWithoutAnnotation");

        final Class<?> c2 = mockC2.build();
        assertFalse(ml.hasMetadata(c2, annotation));
        //System.out.println(ml.hasMetadata(c2, annotation));


//Creating the class with prefix and without annotation

        final IClassWriter mockC3 = ClassMock.of("ClassWithAnnotationOnAnotherElement");
        mockC3.field("id").type(Integer.class);
        final Class<?> c3 = mockC3.build();
        assertTrue(ml.hasMetadata(c3.getDeclaredField("id"), annotation));
        //System.out.println(ml.hasMetadata(c3.getDeclaredField("id"), annotation));
    }
}
