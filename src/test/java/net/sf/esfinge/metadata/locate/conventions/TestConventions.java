package net.sf.esfinge.metadata.locate.conventions;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Method;

import org.junit.BeforeClass;
import org.junit.Test;

import net.sf.esfinge.classmock.ClassMock;
import net.sf.esfinge.classmock.api.IClassWriter;
import net.sf.esfinge.metadata.AnnotationReadingException;
import net.sf.esfinge.metadata.factory.LocatorsFactory;
import net.sf.esfinge.metadata.locate.MetadataLocator;
import net.sf.esfinge.metadata.locate.RegularLocator;

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
	public void testWithConventionsRegexAnyWherewithMock() throws NoSuchMethodException, SecurityException {
		final IClassWriter mock = ClassMock.of("ForTestingConvention");
		mock.method("regexAnywhereInMehod")                                        // The method name
        .returnTypeAsVoid();
		
		
		Method m = ForTestingConventions.class.getMethod("regexAnywhereInMehod");
		
		//boolean result = l.hasMetadata(ForTestingConvention.class.getMethod("regexAnywhereInMehod"), ForTesting.class);
		
		//assertTrue(result);
	}

}
