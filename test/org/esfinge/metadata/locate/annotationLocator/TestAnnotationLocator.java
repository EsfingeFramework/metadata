package org.esfinge.metadata.locate.annotationLocator;

import static org.junit.Assert.*;
import java.lang.annotation.Annotation;
import org.esfinge.metadata.AnnotationFinder;
import org.esfinge.metadata.locate.annotationLocator.CTAux1.CT04;
import org.esfinge.metadata.locate.annotationLocator.CTAux2.CT07;
import org.esfinge.metadata.locate.annotationLocator.CTAux3.CT10;
import org.junit.Test;

public class TestAnnotationLocator {
	// CT01
	public class CT01 {		
		public void method() {

		}
	}

	@Test 
	public void CT01() throws NoSuchMethodException {
		Annotation an = AnnotationFinder.findAnnotation(CT01.class.getMethod("method", null), Transaction01.class);
		assertNull(an);
		assertFalse(an instanceof Transaction01);
	}	
	
	// CT02
	public class CT02 {
		@Administration01
		public void method() {

		}
	}

	@Test
	public void CT02() throws NoSuchMethodException {
		Annotation an = AnnotationFinder.findAnnotation(CT02.class.getMethod("method", null), Transaction01.class);
		assertNotNull(an);
		assertTrue(an instanceof Transaction01);
	}
	
	// CT03 
	@Administration01
	public class CT03 {
		public void method() {

		}
	}

	@Test
	public void CT03() {
		Annotation an = AnnotationFinder.findAnnotation(CT03.class, Transaction01.class);
		assertNotNull(an);
		assertTrue(an instanceof Transaction01);
	}
	
	//CT04 
	@Test
	public void CT04() {
		Annotation an = AnnotationFinder.findAnnotation(CT04.class.getPackage(), Transaction01.class);
		assertNotNull(an);
		assertTrue(an instanceof Transaction01);
	}
	
	// CT05
	public class CT05 {
		@Administration02
		public void method() {

		}
	}

	@Test
	public void CT05() throws NoSuchMethodException {
		Annotation an = AnnotationFinder.findAnnotation(CT05.class.getMethod("method", null), Transaction02.class);
		assertNull(an);
		assertFalse(an instanceof Transaction02);
	}
	
	// CT06
	@Administration02
	public class CT06 {				
		public void method() {
		}
	}

	@Test
	public void CT06() {
		Annotation an = AnnotationFinder.findAnnotation(CT06.class, Transaction02.class);
		assertNull(an);
		assertFalse(an instanceof Transaction02);
	}	
	
	//CT07
	@Test
	public void CT07() {
		Annotation an = AnnotationFinder.findAnnotation(CT07.class.getPackage(), Transaction02.class);
		assertNull(an);
		assertFalse(an instanceof Transaction02);
	}
	
	// CT08
	public class CT08 {
		@Administration03
		public void method() {

		}
	}

	@Test
	public void CT08() throws NoSuchMethodException {
		Annotation an = AnnotationFinder.findAnnotation(CT08.class.getMethod("method", null), Transaction03.class);
		assertNotNull(an);
		assertTrue(an instanceof Transaction03);
	}
	
	// CT09
	@Administration03
	public class CT09 {
		public void method() {

		}
	}

	@Test
	public void CT09() {
		Annotation an = AnnotationFinder.findAnnotation(CT09.class, Transaction03.class);
		assertNotNull(an);
		assertTrue(an instanceof Transaction03);
	}
	
	//CT10
	@Test
	public void CT10() {
		Annotation an = AnnotationFinder.findAnnotation(CT10.class.getPackage(), Transaction03.class);
		assertNotNull(an);
		assertTrue(an instanceof Transaction03);
	}

}
