package net.sf.esfinge.metadata.locate.searchenclosing;

import static org.junit.Assert.assertTrue;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.junit.BeforeClass;
import org.junit.Test;

import net.sf.esfinge.metadata.AnnotationReadingException;
import net.sf.esfinge.metadata.factory.LocatorsFactory;
import net.sf.esfinge.metadata.locate.MetadataLocator;

public class TestSearchOnEnclosingElements {
	
	private static MetadataLocator l;
	
	@BeforeClass
	public static void initLocator() throws AnnotationReadingException {
		l = LocatorsFactory.createLocatorsChain(AcceptsEnclosing.class);
	}

	@Test
	public void tryToFindOnClass() {
		boolean isPresent =l.hasMetadata(ClassWithEnclosingAnnotation.class, AcceptsEnclosing.class);
		assertTrue(isPresent);
	}
	
	@Test
	public void tryToFindOnMethod() throws NoSuchMethodException, SecurityException {
		Method m = ClassWithEnclosingAnnotation.class.getMethod("methodWithoutAnnotation");
		boolean isPresent =l.hasMetadata(m, AcceptsEnclosing.class);
		assertTrue(isPresent);
	}
	
	@Test
	public void tryToFindOnField() throws NoSuchFieldException, SecurityException {
		Field f = ClassWithEnclosingAnnotation.class.getField("attributeWithoutAnnotation");
		boolean isPresent =l.hasMetadata(f, AcceptsEnclosing.class);
		assertTrue(isPresent);
	}

}
