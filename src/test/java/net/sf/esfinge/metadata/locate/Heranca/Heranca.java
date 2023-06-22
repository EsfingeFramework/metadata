package net.sf.esfinge.metadata.locate.Heranca;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.lang.annotation.Annotation;

import net.sf.esfinge.metadata.AnnotationReadingException;
import net.sf.esfinge.metadata.locate.RegularLocator;
import org.junit.Test;

import net.sf.esfinge.metadata.AnnotationFinder;
import net.sf.esfinge.metadata.locate.InheritanceLocator;
import net.sf.esfinge.metadata.locate.MetadataLocationException;
import net.sf.esfinge.metadata.locate.Heranca.Interfaces.ClassNotAnnotation;
import net.sf.esfinge.metadata.locate.Heranca.Interfaces.ClassWithAnnotation;

public class Heranca {
	
	
	InheritanceLocator locator = new InheritanceLocator();

	@Test
	public void testNullInterface() {
		locator.setNextLocator(new RegularLocator());
		Annotation an = locator.findMetadata(ClassNotAnnotation.class, AnnotationReq.class);

		assertNull(an);
		assertFalse(an instanceof AnnotationReq);

	}
	
	@Test
	public void testNullSuper() {
		locator.setNextLocator(new RegularLocator());
		Annotation an = locator.findMetadata(Son.class, AnnotationReq.class);
		assertNull(an);
		assertFalse(an instanceof AnnotationReq);

	}
	
	@Test
	public void testNullSuperIn2Level() {
		locator.setNextLocator(new RegularLocator());
		Annotation an = locator.findMetadata(Neto.class, AnnotationReq.class);
		assertNull(an);
		//assertFalse(an instanceof AnnotationReq);

	}

	
	//TODO Testes que retornam true
	
	@Test
	public void testAnnotationFinder() throws AnnotationReadingException {
		
		//assertNull(an);
		
		assertTrue(AnnotationFinder.existAnnotation(ClassWithAnnotation.class, AnnotationReq.class));

	}

	
	@Test
	public void testReturnInInterface() {
		locator.setNextLocator(new RegularLocator());
		Annotation an = locator.findMetadata(ClassWithAnnotation.class, AnnotationReq.class);
		assertNotNull(an);
		assertTrue(an instanceof AnnotationReq);

	}
	
	@Test
	public void testReturnInSuper() {
		locator.setNextLocator(new RegularLocator());
		Annotation an = locator.findMetadata(SonWithMetadata.class, AnnotationReq.class);
		assertNotNull(an);
		assertTrue(an instanceof AnnotationReq);

	}
	
	@Test
	public void testReturnInSuperIn2Level() {
		locator.setNextLocator(new RegularLocator());
		Annotation an = locator.findMetadata(NetoWithMetadata.class, AnnotationReq.class);
		assertNotNull(an);
		assertTrue(an instanceof AnnotationReq);

	}

	//TODO Testes que retornam false
	//TODO testsForMethods
	@Test
	public void testMethodNullInInterface() throws MetadataLocationException, NoSuchMethodException, SecurityException {

		locator.setNextLocator(new RegularLocator());
		Annotation an = locator.findMetadata(MethodInterfaceAnnotation.class.getMethod("value1"), AnnotationReq.class);
		assertNull(an);
		assertFalse(an instanceof AnnotationReq);

	}
	
	@Test
	public void testMethodNullInSuperclass() throws MetadataLocationException, NoSuchMethodException, SecurityException {

		locator.setNextLocator(new RegularLocator());
		Annotation an = locator.findMetadata(MethodSuperclassAnnotation.class.getMethod("value1"), AnnotationReq.class);
		assertNull(an);
		assertFalse(an instanceof AnnotationReq);

	}
	//TODO Testes que retornam True
	//TODO testsForMethods
	
	@Test
	public void testNotNullMethodInInterface() throws MetadataLocationException, NoSuchMethodException, SecurityException {

		locator.setNextLocator(new RegularLocator());
		Annotation an = locator.findMetadata(MethodInterfaceAnnotation.class.getMethod("value2"), AnnotationReq.class);
		assertNotNull(an);
		assertTrue(an instanceof AnnotationReq);

	}
	@Test
	public void testMethodNotNullInSuperclass() throws MetadataLocationException, NoSuchMethodException, SecurityException {

		locator.setNextLocator(new RegularLocator());
		Annotation an = locator.findMetadata(MethodSuperclassAnnotation.class.getMethod("value2"), AnnotationReq.class);
		assertNotNull(an);
		assertTrue(an instanceof AnnotationReq);

	}


	
}
