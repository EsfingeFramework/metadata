package net.sf.esfinge.metadata.locate.locators.FindAllMetadata;

import net.sf.esfinge.metadata.AnnotationReadingException;
import net.sf.esfinge.metadata.factory.LocatorsFactory;
import net.sf.esfinge.metadata.locate.MetadataLocator;
import net.sf.esfinge.metadata.locate.locators.FindMetadata.WithoutAnnotation.ClassWithoutAnnotation;
import org.junit.Test;

import java.lang.annotation.Annotation;

import static org.junit.Assert.*;

public class InsideAnnotationLocatorTest {
    @Test
    public  void findMetadataInsideAnnotation() throws AnnotationReadingException, NoSuchMethodException, NoSuchFieldException {



        final Class<? extends Annotation> annotation = ToTestInside.class;

        MetadataLocator ml = LocatorsFactory.createLocatorsChain(annotation);

        final Class<?> c1 = WithAnnotation.class;
        assertNotNull(ml.findAllMetadata(c1));
        assertNotNull(ml.findAllMetadata(c1.getMethod("setId")));
        assertNotNull(ml.findAllMetadata(c1.getDeclaredField("id")));


        final Class<?> c2 = ClassWithoutAnnotation.class;

        assertTrue(ml.findAllMetadata(c2).isEmpty());
        assertTrue(ml.findAllMetadata(c2.getMethod("setId")).isEmpty());
        assertTrue(ml.findAllMetadata(c2.getDeclaredField("id")).isEmpty());


    }
}
