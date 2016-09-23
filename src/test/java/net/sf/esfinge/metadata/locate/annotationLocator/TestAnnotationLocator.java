package net.sf.esfinge.metadata.locate.annotationLocator;

import static org.junit.Assert.*;

import java.lang.annotation.Annotation;

import org.junit.Test;

import net.sf.esfinge.metadata.locate.AnnotationLocator;
import net.sf.esfinge.metadata.locate.annotationLocator.CTAux1.CT04;
import net.sf.esfinge.metadata.locate.annotationLocator.CTAux2.CT07;
import net.sf.esfinge.metadata.locate.annotationLocator.CTAux3.CT10;
import net.sf.esfinge.metadata.validate.needsToHave.Logging01;

public class TestAnnotationLocator {
	
	private AnnotationLocator locator = new AnnotationLocator();
	
	// CT01
	public class CT01 {		
		public void method() {

		}
	}

	@Test 
	public void CT01() throws NoSuchMethodException {
		System.out.println("CT01");
		Annotation an = locator.findMetadata(CT01.class.getMethod("method", null), Transaction01.class);
		assertNull(an);
		assertFalse(an instanceof Transaction01);

	}	
	
	// CT02
	public class CT02 {
		@Logging01 @Administration01
		public void method() {

		}
	}

	@Test
	public void CT02() throws NoSuchMethodException {
		System.out.println("CT02");
		Annotation an = locator.findMetadata(CT02.class.getMethod("method", null), Transaction01.class);
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
		System.out.println("CT03");
		Annotation an = locator.findMetadata(CT03.class, Transaction01.class);
		assertNotNull(an);
		assertTrue(an instanceof Transaction01);
		
	}
	
	//CT04 
	@Test
	public void CT04() {
		System.out.println("CT04");
		Annotation an = locator.findMetadata(CT04.class.getPackage(), Transaction01.class);
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
		System.out.println("CT05");
		Annotation an = locator.findMetadata(CT05.class.getMethod("method", null), Transaction02.class);
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
		System.out.println("CT06");
		Annotation an = locator.findMetadata(CT06.class, Transaction02.class);
		assertNull(an);
		assertFalse(an instanceof Transaction02);
	}	
	
	//CT07
	@Test
	public void CT07() {
		System.out.println("CT07");
		Annotation an = locator.findMetadata(CT07.class.getPackage(), Transaction02.class);
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
		System.out.println("CT08");
		Annotation an = locator.findMetadata(CT08.class.getMethod("method", null), Transaction03.class);
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
		System.out.println("CT09");
		Annotation an = locator.findMetadata(CT09.class, Transaction03.class);
		assertNotNull(an);
		assertTrue(an instanceof Transaction03);
	}
	
	//CT10
	@Test
	public void CT10() {
		System.out.println("CT10");
		Annotation an = locator.findMetadata(CT10.class.getPackage(), Transaction03.class);
		assertNotNull(an);
		assertTrue(an instanceof Transaction03);
	}

}
