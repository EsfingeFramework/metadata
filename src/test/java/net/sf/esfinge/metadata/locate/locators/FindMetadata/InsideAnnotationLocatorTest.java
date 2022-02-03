package net.sf.esfinge.metadata.locate.locators.FindMetadata;

import net.sf.esfinge.metadata.AnnotationReadingException;
import net.sf.esfinge.metadata.factory.LocatorsFactory;
import net.sf.esfinge.metadata.locate.MetadataLocator;
import net.sf.esfinge.metadata.locate.locators.FindMetadata.WithoutAnnotation.ClassWithoutAnnotation;

import java.lang.annotation.Annotation;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
public class InsideAnnotationLocatorTest {
    @Test
    public  void findMetadataInsideAnnotation() throws AnnotationReadingException, NoSuchMethodException, NoSuchFieldException {



        final Class<? extends Annotation> annotation = ToTestInside.class;

        MetadataLocator ml = LocatorsFactory.createLocatorsChain(annotation);

        final Class<?> c1 = WithAnnotation.class;
        assertNotNull(ml.hasMetadata(c1, annotation));
        assertNotNull(ml.hasMetadata(c1.getMethod("setId"), annotation));
        assertNotNull(ml.hasMetadata(c1.getDeclaredField("id"), annotation));


        final Class<?> c2 = ClassWithoutAnnotation.class;

        assertNull(ml.hasMetadata(c2, annotation));
        assertNull(ml.hasMetadata(c2.getMethod("setId"), annotation));
        assertNull(ml.hasMetadata(c2.getDeclaredField("id"), annotation));


    }
}
