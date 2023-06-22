package net.sf.esfinge.metadata.locate.conventions.classmock;

import net.sf.esfinge.classmock.ClassMock;
import net.sf.esfinge.classmock.api.IClassWriter;
import net.sf.esfinge.metadata.AnnotationReadingException;
import net.sf.esfinge.metadata.factory.LocatorsFactory;
import net.sf.esfinge.metadata.locate.MetadataLocator;
import net.sf.esfinge.metadata.locate.conventions.annotations.HasMethodReturnType;
import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.lang.annotation.Annotation;
import java.util.List;


public class ClassMockMethodReturnTypeTest {
    @Test
    public void conventionsWithMapping() throws AnnotationReadingException, NoSuchMethodException{


        final Class<? extends Annotation> annotation =  HasMethodReturnType.class;
          


//Locator

        MetadataLocator ml =  LocatorsFactory.createLocatorsChain(annotation);



//Creating the class with annotation

        final IClassWriter mockC1 = ClassMock.of("ClassWithAnnotation000258");
        mockC1.method("setId").returnType(List.class).annotation(annotation);
        final Class<?> c1 = mockC1.build();
        //System.out.println(ml.hasMetadata(c1.getMethod("id"), annotation));
        assertTrue(ml.hasMetadata(c1.getMethod("setId"), annotation));



//Creating the class without prefix and without annotation

        final IClassWriter mockC2 = ClassMock.of("ClassWithoutAnnotation0014789");
        final Class<?> c2 = mockC2.build();
        //System.out.println(ml.hasMetadata(c2, annotation));
        assertFalse(ml.hasMetadata(c2, annotation));


//Creating the class with prefix and without annotation

        final IClassWriter mockC3 = ClassMock.of("MethodReturnTypeWithoutAnnotation");
        mockC3.method("id").returnType(Integer.class);
        final Class<?> c3 = mockC3.build();
        //System.out.println(ml.hasMetadata(c3.getDeclaredMethod("id"), annotation));
        assertTrue(ml.hasMetadata(c3.getDeclaredMethod("id"), annotation));
    }
}
