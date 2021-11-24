package net.sf.esfinge.metadata.locate.conventions.classmock;

import net.sf.esfinge.classmock.ClassMock;
import net.sf.esfinge.classmock.api.IClassWriter;
import net.sf.esfinge.classmock.api.IMethodWriter;
import net.sf.esfinge.metadata.AnnotationReadingException;
import net.sf.esfinge.metadata.factory.LocatorsFactory;
import net.sf.esfinge.metadata.locate.MetadataLocator;
import net.sf.esfinge.metadata.locate.conventions.annotations.HasAnnotationOnElement;
import net.sf.esfinge.metadata.locate.conventions.annotations.HaveAnnotationOnElementConvention;


import java.lang.annotation.Annotation;

import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
public class ClassMockHaveAnnotationOnElementTest {
    @Test

    public void conventionsWithMapping() throws AnnotationReadingException, NoSuchMethodException{
        final Class<? extends Annotation> annotation =  HasAnnotationOnElement.class;



//Locator

        MetadataLocator ml =  LocatorsFactory.createLocatorsChain(annotation);



//Creating the class with annotation

        final IClassWriter mockC1 = ClassMock.of("ClassWithAnnotation");
        mockC1.method("setId").annotation(annotation);

        final Class<?> c1 = mockC1.build();
        assertTrue(ml.hasMetadata(c1.getDeclaredMethod("setId"), annotation));




//Creating the class without prefix and without annotation

        final IClassWriter mockC2 = ClassMock.of("ClassWithoutAnnotation");
        mockC2.method("setId");
        final Class<?> c2 = mockC2.build();
        assertFalse(ml.hasMetadata(c2.getDeclaredMethod("setId"), annotation));



//Creating the class with prefix and without annotation

        final IClassWriter mockC3 = ClassMock.of("ClassWithAnnotationOnAnotherElement");
        mockC3.method("setId").annotation(Deprecated.class);

        final Class<?> c3 = mockC3.build();
        assertTrue(ml.hasMetadata(c3.getDeclaredMethod("setId"), annotation));
    }
}
