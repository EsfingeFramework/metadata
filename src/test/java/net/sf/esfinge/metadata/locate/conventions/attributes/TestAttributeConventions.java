package net.sf.esfinge.metadata.locate.conventions.attributes;

import net.sf.esfinge.metadata.AnnotationReadingException;
import net.sf.esfinge.metadata.factory.LocatorsFactory;
import net.sf.esfinge.metadata.locate.MetadataLocator;
import net.sf.esfinge.metadata.locate.conventions.attributes.AtributeAnnotations.*;
import org.junit.Test;

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
    @Test
    public void testElementNameBeforeSuffix() throws NoSuchMethodException, AnnotationReadingException {
        Method m = MockClassConventions.class.getMethod("insertPeople");


        MetadataLocator ml = LocatorsFactory.createLocatorsChain();

        assertTrue(ml.hasMetadata(m, WithAtributeConventionSuffix.class));
        WithAtributeConventionSuffix wac = (WithAtributeConventionSuffix) ml.findMetadata(m,WithAtributeConventionSuffix.class);
        String name = wac.name();
        assertEquals(name,"insert");
    }

    @Test
    public void testElementName() throws NoSuchMethodException, AnnotationReadingException {
        Method m = MockClassConventions.class.getMethod("insertPeople");


        MetadataLocator ml = LocatorsFactory.createLocatorsChain();

        assertTrue(ml.hasMetadata(m, WithElementNameConvention.class));
        WithElementNameConvention wac = (WithElementNameConvention) ml.findMetadata(m,WithElementNameConvention.class);
        String name = wac.name();
        assertEquals(name,"insertPeople");
    }

    @Test
    public void testFixedString() throws NoSuchMethodException, AnnotationReadingException {
        Method m = MockClassConventions.class.getMethod("returnString");


        MetadataLocator ml = LocatorsFactory.createLocatorsChain();

        assertTrue(ml.hasMetadata(m, WithFixedString.class));
        WithFixedString wac = (WithFixedString) ml.findMetadata(m,WithFixedString.class);
        String name = wac.value();
        assertEquals(name,"insert");
    }
    @Test
    public void testFixedBoolean() throws NoSuchMethodException, AnnotationReadingException {
        Method m = MockClassConventions.class.getMethod("returnBoolean");


        MetadataLocator ml = LocatorsFactory.createLocatorsChain();

        assertTrue(ml.hasMetadata(m, WithFixedBoolean.class));
        WithFixedBoolean wac = (WithFixedBoolean) ml.findMetadata(m,WithFixedBoolean.class);
        boolean value = wac.value();
        assertTrue(value);
    }

    @Test
    public void testFixedByte() throws NoSuchMethodException, AnnotationReadingException {
        Method m = MockClassConventions.class.getMethod("returnByte");


        MetadataLocator ml = LocatorsFactory.createLocatorsChain();

        assertTrue(ml.hasMetadata(m, WithFixedByte.class));
        WithFixedByte wac = (WithFixedByte) ml.findMetadata(m,WithFixedByte.class);
        byte value = wac.value();
        assertEquals(value,Byte.MAX_VALUE);
    }

    @Test
    public void testFixedDouble() throws NoSuchMethodException, AnnotationReadingException {
        Method m = MockClassConventions.class.getMethod("returnDouble");


        MetadataLocator ml = LocatorsFactory.createLocatorsChain();

        assertTrue(ml.hasMetadata(m, WithFixedDouble.class));
        WithFixedDouble wac = (WithFixedDouble) ml.findMetadata(m,WithFixedDouble.class);
        double value = wac.value();
        assertEquals(value,Double.MAX_VALUE,0);
    }
    @Test
    public void testFixedFloat() throws NoSuchMethodException, AnnotationReadingException {
        Method m = MockClassConventions.class.getMethod("returnFloat");


        MetadataLocator ml = LocatorsFactory.createLocatorsChain();

        assertTrue(ml.hasMetadata(m, WithFixedFloat.class));
        WithFixedFloat wac = (WithFixedFloat) ml.findMetadata(m,WithFixedFloat.class);
        float value = wac.value();
        assertEquals(value,Float.MAX_VALUE,0);
    }
    @Test
    public void testFixedInteger() throws NoSuchMethodException, AnnotationReadingException {
        Method m = MockClassConventions.class.getMethod("returnInt");


        MetadataLocator ml = LocatorsFactory.createLocatorsChain();

        assertTrue(ml.hasMetadata(m, WithFixedInteger.class));
        WithFixedInteger wac = (WithFixedInteger) ml.findMetadata(m,WithFixedInteger.class);
        int value = wac.value();
        assertEquals(value,Integer.MAX_VALUE);
    }
    @Test
    public void testFixedShort() throws NoSuchMethodException, AnnotationReadingException {
        Method m = MockClassConventions.class.getMethod("returnShort");


        MetadataLocator ml = LocatorsFactory.createLocatorsChain();

        assertTrue(ml.hasMetadata(m, WithFixedShort.class));
        WithFixedShort wac = (WithFixedShort) ml.findMetadata(m,WithFixedShort.class);
        short value = wac.value();
        assertEquals(value,Short.MAX_VALUE);
    }
    @Test
    public void testFixedChar() throws NoSuchMethodException, AnnotationReadingException {
        Method m = MockClassConventions.class.getMethod("returnChar");


        MetadataLocator ml = LocatorsFactory.createLocatorsChain();

        assertTrue(ml.hasMetadata(m, WithFixedChar.class));
        WithFixedChar wac = (WithFixedChar) ml.findMetadata(m,WithFixedChar.class);
        char value = wac.value();
        assertEquals(value,Character.DECIMAL_DIGIT_NUMBER);
    }
    @Test
    public void testFixedLong() throws NoSuchMethodException, AnnotationReadingException {
        Method m = MockClassConventions.class.getMethod("returnLong");


        MetadataLocator ml = LocatorsFactory.createLocatorsChain();

        assertTrue(ml.hasMetadata(m, WithFixedLong.class));
        WithFixedLong wac = (WithFixedLong) ml.findMetadata(m,WithFixedLong.class);
        long value = wac.value();
        assertEquals(value,Long.MAX_VALUE);
    }

    @Test
    public void testWithTwoAtributes() throws NoSuchMethodException, AnnotationReadingException {
        Method m = MockClassConventions.class.getMethod("insertPerson", String.class, int.class);


        MetadataLocator ml = LocatorsFactory.createLocatorsChain();

        assertTrue(ml.hasMetadata(m, WithTwoAtributes.class));
        WithTwoAtributes wac = (WithTwoAtributes) ml.findMetadata(m,WithTwoAtributes.class);
        String name = wac.name();
        int age = wac.age();
        assertEquals(name,"Joao");
        assertEquals(age,22);
    }

}
