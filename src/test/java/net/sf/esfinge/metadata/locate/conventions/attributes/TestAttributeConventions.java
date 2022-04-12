package net.sf.esfinge.metadata.locate.conventions.attributes;

import net.sf.esfinge.classmock.ClassMock;
import net.sf.esfinge.classmock.api.IClassWriter;
import net.sf.esfinge.metadata.AnnotationReadingException;
import net.sf.esfinge.metadata.factory.LocatorsFactory;
import net.sf.esfinge.metadata.locate.MetadataLocator;
import net.sf.esfinge.metadata.locate.conventions.annotations.HasPrefix;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestAttributeConventions {
    @Test
    public void testAtribute() throws NoSuchMethodException, AnnotationReadingException {

        Method m = MockClassConventions.class.getMethod("insertPeople");


        MetadataLocator ml = LocatorsFactory.createLocatorsChain();

        assertTrue(ml.hasMetadata(m, WithAtributeConventions.class));
        WithAtributeConventions wac = (WithAtributeConventions) ml.findMetadata(m,WithAtributeConventions.class);
        String name = wac.name();
        assertEquals(name,"People");



    }
}
