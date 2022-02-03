package net.sf.esfinge.metadata.locate.locators.HasMetadata;

import net.sf.esfinge.metadata.AnnotationReadingException;
import net.sf.esfinge.metadata.factory.LocatorsFactory;
import net.sf.esfinge.metadata.locate.MetadataLocator;
import net.sf.esfinge.metadata.locate.locators.HasMetadata.WithoutAnnotation.ClassWithoutAnnotation;

import java.lang.annotation.Annotation;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class InsideAnnotationLocatorTest {
    @Test
    public void hasMetadataInsideAnnotation() throws AnnotationReadingException, NoSuchMethodException, NoSuchFieldException {



        final Class<? extends Annotation> annotation = ToTestInside.class;

        MetadataLocator ml = LocatorsFactory.createLocatorsChain(annotation);

        final Class<?> c1 = WithAnnotation.class;

        assertTrue(ml.hasMetadata(c1, annotation));
        assertTrue(ml.hasMetadata(c1.getMethod("setId"), annotation));
        assertTrue(ml.hasMetadata(c1.getDeclaredField("id"), annotation));



        final Class<?> c2 = ClassWithoutAnnotation.class;


        assertFalse(ml.hasMetadata(c2, annotation));
        assertFalse(ml.hasMetadata(c2.getMethod("setId"), annotation));
        assertFalse(ml.hasMetadata(c2.getDeclaredField("id"), annotation));


    }
}
