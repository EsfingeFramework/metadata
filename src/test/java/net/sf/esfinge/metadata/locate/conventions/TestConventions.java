package net.sf.esfinge.metadata.locate.conventions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.junit.BeforeClass;
import org.junit.Test;

import net.sf.esfinge.classmock.ClassMock;
import net.sf.esfinge.classmock.api.IClassWriter;
import net.sf.esfinge.metadata.AnnotationReadingException;
import net.sf.esfinge.metadata.factory.LocatorsFactory;
import net.sf.esfinge.metadata.locate.MetadataLocator;

public class TestConventions {
	
	private static MetadataLocator l;
	
	@BeforeClass
	public static void initLocator() throws AnnotationReadingException {
		l = LocatorsFactory.createLocatorsChain(ForTesting.class);
	}

	@Test
	public void testWithAnnotation() throws NoSuchMethodException, SecurityException {
		Method m = ForTestingConventions.class.getMethod("withAnnotationMethod");
		boolean result = l.hasMetadata(m, ForTesting.class);
		assertTrue(result);
		// find metadata
		Annotation an = l.findMetadata(m, ForTesting.class);
		assertEquals(an.annotationType(), ForTesting.class);
	}
	
	@Test
	public void testNoConventions() throws NoSuchMethodException, SecurityException {
		Method m = ForTestingConventions.class.getMethod("noConventionMethod");
		
		boolean result = l.hasMetadata(m, ForTesting.class);
		
		assertFalse(result);
	}

	@Test
	public void testWithConventionsPrefix() throws NoSuchMethodException, SecurityException {
		Method m = ForTestingConventions.class.getMethod("prefixMethod");
		
		boolean result = l.hasMetadata(m, ForTesting.class);
		
		assertTrue(result);
	}
	
	@Test
	public void testWithConventionsSuffix() throws NoSuchMethodException, SecurityException {
		Method m = ForTestingConventions.class.getMethod("methodSuffix");
		
		boolean result = l.hasMetadata(m, ForTesting.class);
		
		assertTrue(result);
	}
	
	@Test
	public void testWithConventionsRegex() throws NoSuchMethodException, SecurityException {
		Method m = ForTestingConventions.class.getMethod("methodContainsRegex");
		
		boolean result = l.hasMetadata(m, ForTesting.class);
		
		assertTrue(result);
	}
	
	@Test
	public void testWithConventionsRegexAnyWhere() throws NoSuchMethodException, SecurityException {
		Method m = ForTestingConventions.class.getMethod("regexAnywhereInMehod");
		
		boolean result = l.hasMetadata(m, ForTesting.class);
		
		assertTrue(result);
	}
	
	@Test
	public void testWithFieldTypeConvention() throws NoSuchFieldException, SecurityException  {
		Field f1 = ForTestingConventions.class.getField("field1");
		Field f2 = ForTestingConventions.class.getField("field2");
		Field f3 = ForTestingConventions.class.getField("field3");
		
		assertTrue("Type Number has the convention", l.hasMetadata(f1, AsNumberInField.class));
		assertTrue("Type Integer is subclass of Number and has the convention", l.hasMetadata(f2, AsNumberInField.class));
		assertFalse("Type String does not hve the convention", l.hasMetadata(f3, AsNumberInField.class));
	}
	
	@Test
	public void whenTwoConventionsNeedToBeTrue() throws NoSuchFieldException, SecurityException  {
		Field f1 = ClassToTestAnnotationsWithTwoConventions.class.getField("intField");
		Field f2 = ClassToTestAnnotationsWithTwoConventions.class.getField("nointField");
		Field f3 = ClassToTestAnnotationsWithTwoConventions.class.getField("intOtherField");
		
		assertTrue("Has two conventions", l.hasMetadata(f1, WithTwoConventions.class));
		assertFalse("Has only the type convention", l.hasMetadata(f2, WithTwoConventions.class));
		assertFalse("Has only the prefix", l.hasMetadata(f3, WithTwoConventions.class));
	}
	
	@Test
	public void testWithConventionsRegexAnyWherewithMock() throws NoSuchMethodException, SecurityException {
		final IClassWriter mock = ClassMock.of("ForTestingConvention");
		mock.method("regexAnywhereInMehod")                                        // The method name
        .returnTypeAsVoid();
		
		
		Method m = ForTestingConventions.class.getMethod("regexAnywhereInMehod");
		
		//boolean result = l.hasMetadata(ForTestingConvention.class.getMethod("regexAnywhereInMehod"), ForTesting.class);
		
		//assertTrue(result);
	}

}
