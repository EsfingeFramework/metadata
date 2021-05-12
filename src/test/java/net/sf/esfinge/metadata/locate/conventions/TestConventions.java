package net.sf.esfinge.metadata.locate.conventions;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.reflect.Method;

import org.junit.Test;

import net.sf.esfinge.metadata.locate.MetadataLocator;
import net.sf.esfinge.metadata.locate.RegularLocator;

public class TestConventions {

	@Test
	public void testWithAnnotation() throws NoSuchMethodException, SecurityException {
		MetadataLocator l = new ConventionsLocator();
		l.setNextLocator(new RegularLocator());
		
		Method m = ForTestingConventions.class.getMethod("withAnnotationMethod");
		
		boolean result = l.hasMetadata(m, ForTesting.class);
		
		assertTrue(result);
	}
	
	@Test
	public void testNoConventions() throws NoSuchMethodException, SecurityException {
		MetadataLocator l = new ConventionsLocator();
		l.setNextLocator(new RegularLocator());
		
		Method m = ForTestingConventions.class.getMethod("noConventionMethod");
		
		boolean result = l.hasMetadata(m, ForTesting.class);
		
		assertFalse(result);
	}

	@Test
	public void testWithConventionsPrefix() throws NoSuchMethodException, SecurityException {
		MetadataLocator l = new ConventionsLocator();
		l.setNextLocator(new RegularLocator());
		
		Method m = ForTestingConventions.class.getMethod("prefixMethod");
		
		boolean result = l.hasMetadata(m, ForTesting.class);
		
		assertTrue(result);
	}
	
	@Test
	public void testWithConventionsSuffix() throws NoSuchMethodException, SecurityException {
		MetadataLocator l = new ConventionsLocator();
		l.setNextLocator(new RegularLocator());
		
		Method m = ForTestingConventions.class.getMethod("methodSuffix");
		
		boolean result = l.hasMetadata(m, ForTesting.class);
		
		assertTrue(result);
	}
	

}
