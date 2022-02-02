package net.sf.esfinge.metadata.locate.locators.HasMetadata;


import net.sf.esfinge.metadata.AnnotationReadingException;
import net.sf.esfinge.metadata.factory.LocatorsFactory;
import net.sf.esfinge.metadata.locate.MetadataLocator;
import net.sf.esfinge.metadata.locate.locators.HasMetadata.WithoutAnnotation.ClassWithoutAnnotation;


import java.lang.annotation.Annotation;

public class EnclosingElementLocatorTest {

    public static void main(String args[]) throws AnnotationReadingException, NoSuchMethodException, NoSuchFieldException {



        final Class<? extends Annotation> annotation = ToTestEnclosing.class;

        MetadataLocator ml = LocatorsFactory.createLocatorsChain(annotation);

        final Class<?> c1 = WithAnnotation.class;
        System.out.println(ml.hasMetadata(c1, annotation)+" "+c1.getName());
        //assertTrue(ml.hasMetadata(c1, annotation));
        System.out.println(ml.hasMetadata(c1.getMethod("setId"), annotation)+" "+c1.getName());
         //assertTrue(ml.hasMetadata(c3, annotation));

        System.out.println(ml.hasMetadata(c1.getDeclaredField("id"), annotation)+" "+c1.getName());


        final Class<?> c2 = ClassWithoutAnnotation.class;

        System.out.println(ml.hasMetadata(c2, annotation)+" "+c2.getName());
        System.out.println(ml.hasMetadata(c2.getMethod("setId"), annotation)+" "+c2.getName());
        System.out.println(ml.hasMetadata(c2.getDeclaredField("id"), annotation)+" "+c2.getName());
        //assertFalse(ml.hasMetadata(c2, annotation));

    }
}
