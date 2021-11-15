package net.sf.esfinge.metadata.locate.conventions.classmock;

import net.sf.esfinge.classmock.ClassMock;
import net.sf.esfinge.classmock.api.IClassWriter;
import net.sf.esfinge.metadata.AnnotationReadingException;
import net.sf.esfinge.metadata.factory.LocatorsFactory;
import net.sf.esfinge.metadata.locate.MetadataLocator;
import net.sf.esfinge.metadata.locate.conventions.annotations.HasSuffix;
import java.lang.annotation.Annotation;

import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ClassMockSuffixTest {


    public void conventionsWithMapping() throws Exception {

        final Class<? extends Annotation> annotation =  HasSuffix.class;

        MetadataLocator ml = null;
        try {
            ml = LocatorsFactory.createLocatorsChain(annotation);
        } catch (AnnotationReadingException e) {
            e.printStackTrace();
        }

        final IClassWriter mockC1 = ClassMock.of("ClassEndsWithSuffix");
        mockC1.annotation(annotation);
        final Class<?> c1 = mockC1.build();
        //assertTrue(ml.hasMetadata(c1, annotation));
        System.out.println(ml.hasMetadata(c1, annotation));
//Creating the class without prefix and without annotation

        final IClassWriter mockC2 = ClassMock.of("ClassWithoutAnnotation");
        mockC2.method("methodDontEndsWith");
        mockC2.field("FieldDontEndsWith");
        final Class<?> c2 = mockC2.build();
        //assertFalse(ml.hasMetadata(c1, annotation));
        System.out.println(ml.hasMetadata(c2, annotation));

//Creating the class with prefix and without annotation

        final IClassWriter mockC3 = ClassMock.of("WithoutAnnotationClassEndsWithSuffix");
        final Class<?> c3 = mockC3.build();
        //assertTrue(ml.hasMetadata(c3, annotation));
        System.out.println(ml.hasMetadata(c3, annotation));
    }
}
