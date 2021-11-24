package net.sf.esfinge.metadata.locate.conventions.classmock;

import net.sf.esfinge.classmock.ClassMock;
import net.sf.esfinge.classmock.api.IClassWriter;
import net.sf.esfinge.metadata.AnnotationReadingException;
import net.sf.esfinge.metadata.factory.LocatorsFactory;
import net.sf.esfinge.metadata.locate.MetadataLocator;
import net.sf.esfinge.metadata.locate.conventions.annotations.HasRegex;


import java.lang.annotation.Annotation;

import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class ClassMockRegularExpressionTest {
    @Test

    public void conventionsWithMapping() throws AnnotationReadingException {


        final Class<? extends Annotation> annotation =  HasRegex.class;

        MetadataLocator ml = LocatorsFactory.createLocatorsChain(annotation);



//Creating the class with annotation

        final IClassWriter mockC1 = ClassMock.of("ClassWithAnnotationRegex");
        mockC1.annotation(annotation);
        final Class<?> c1 = mockC1.build();
        assertTrue(ml.hasMetadata(c1, annotation));




//Creating the class without prefix and without annotation

        final IClassWriter mockC2 = ClassMock.of("ClassWithoutAnnotation");
       final Class<?> c2 = mockC2.build();
        assertFalse(ml.hasMetadata(c2, annotation));


//Creating the class with prefix and without annotation

        final IClassWriter mockC3 = ClassMock.of("ClassWithoutAnnotationRegex");
        final Class<?> c3 = mockC3.build();
        assertTrue(ml.hasMetadata(c3, annotation));
    }
}
