package net.sf.esfinge.metadata.locate.Heranca;

import static org.junit.Assert.*;

import java.lang.annotation.Annotation;

import org.junit.Test;

import net.sf.esfinge.metadata.locate.annotationLocator.Transaction01;
import net.sf.esfinge.metadata.locate.InheritanceLocator;
import net.sf.esfinge.metadata.locate.Heranca.Interfaces.ClassNotAnnotation;
import net.sf.esfinge.metadata.locate.Heranca.Interfaces.ClassWithAnnotation;
import net.sf.esfinge.metadata.locate.annotationLocator.TestAnnotationLocator.CT01;

public class Heranca {
	
	
	InheritanceLocator locator = new InheritanceLocator();
	//TODO Falta criar os testes para fields.........
	
	
	
	//TODO Testes que retornam false
	@Test
	public void testNullInterface() {
		Annotation an = locator.findMetadata(ClassNotAnnotation.class, AnnotationReq.class);
		assertNull(an);
		assertFalse(an instanceof AnnotationReq);

	}
	
	@Test
	public void testNullSuper() {
		Annotation an = locator.findMetadata(Son.class, AnnotationReq.class);
		assertNull(an);
		assertFalse(an instanceof AnnotationReq);

	}
	
	@Test
	public void testNullSuperIn2Level() {
		Annotation an = locator.findMetadata(Neto.class, AnnotationReq.class);
		assertNull(an);
		assertFalse(an instanceof AnnotationReq);

	}

	
	
	
	
	//TODO Testes que retornam true
	@Test
	public void testReturnInInterface() {
		Annotation an = locator.findMetadata(ClassWithAnnotation.class, AnnotationReq.class);
		assertNotNull(an);
		assertTrue(an instanceof AnnotationReq);

	}
	
	@Test
	public void testReturnInSuper() {
		Annotation an = locator.findMetadata(SonWithMetadata.class, AnnotationReq.class);
		assertNotNull(an);
		assertTrue(an instanceof AnnotationReq);

	}
	
	@Test
	public void testReturnInSuperIn2Level() {
		Annotation an = locator.findMetadata(NetoWithMetadata.class, AnnotationReq.class);
		assertNotNull(an);
		assertTrue(an instanceof AnnotationReq);

	}

}
