package net.sf.esfinge.metadata.locate.conventions.classmock;

import net.sf.esfinge.classmock.ClassMock;
import net.sf.esfinge.classmock.api.IClassWriter;
import net.sf.esfinge.classmock.api.IMethodWriter;

import net.sf.esfinge.metadata.AnnotationReadingException;
import net.sf.esfinge.metadata.factory.LocatorsFactory;
import net.sf.esfinge.metadata.locate.MetadataLocator;

import net.sf.esfinge.metadata.locate.conventions.annotations.MethodHasParamList;


import java.lang.annotation.Annotation;

import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class ClassMockExactParamListTest {
    @Test

    public void conventionsWithMapping() throws AnnotationReadingException, NoSuchMethodException {

        final Class<? extends Annotation> annotation =  MethodHasParamList.class;



//Locator

        MetadataLocator ml =  LocatorsFactory.createLocatorsChain(annotation);



//Creating the class with annotation

        final IClassWriter mockC1 = ClassMock.of("ClassWithAnnotation09");
        IMethodWriter m0 = mockC1.method("setId");
        m0.parameter("id",Integer.class);
        mockC1.annotation(annotation);
        //mockC1.method("setId").annotation(annotation);

        final Class<?> c1 = mockC1.build();
        assertTrue(ml.hasMetadata(c1, annotation));




//Creating the class without prefix and without annotation

        final IClassWriter mockC2 = ClassMock.of("ClassWithoutAnnotation00");
        mockC2.method("setName").parameter("name",String.class);
        final Class<?> c2 = mockC2.build();
        assertFalse(ml.hasMetadata(c2.getDeclaredMethod("setName",String.class), annotation));



//Creating the class with prefix and without annotation

        final IClassWriter mockC3 = ClassMock.of("MethodHasParameterOfTypeWithoutAnnotation");
        IMethodWriter m1 = mockC3.method("setId");
        m1.parameter("id",Integer.class);
        m1.parameter("nome",String.class);
        final Class<?> c3 = mockC3.build();
        assertTrue(ml.hasMetadata(c3.getDeclaredMethod("setId",Integer.class,String.class), annotation));
    }
}
