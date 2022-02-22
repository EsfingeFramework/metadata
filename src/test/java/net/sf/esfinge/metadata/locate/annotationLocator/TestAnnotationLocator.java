package net.sf.esfinge.metadata.locate.annotationLocator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.lang.annotation.Annotation;
import java.util.List;

import net.sf.esfinge.metadata.AnnotationReadingException;
import net.sf.esfinge.metadata.factory.LocatorsFactory;
import net.sf.esfinge.metadata.locate.MetadataLocator;
import org.junit.Test;

import net.sf.esfinge.metadata.AnnotationFinder;
import net.sf.esfinge.metadata.locate.InsideAnnotationLocator;
import net.sf.esfinge.metadata.locate.annotationLocator.CTAux1.CT04;
import net.sf.esfinge.metadata.locate.annotationLocator.CTAux2.CT07;
import net.sf.esfinge.metadata.locate.annotationLocator.CTAux3.CT10;
import net.sf.esfinge.metadata.validate.needsToHave.Logging01;

public class TestAnnotationLocator {
	
	private InsideAnnotationLocator locator = new InsideAnnotationLocator();
	private MetadataLocator ml= LocatorsFactory.createLocatorsChain(Transaction02.class);

	public TestAnnotationLocator() throws AnnotationReadingException {
	}

	// CT01
	public class CT01 {		
		public void method() {

		}
	}

	@Test 
	public void CT01() throws NoSuchMethodException, AnnotationReadingException {
		List<Annotation> locatorList = AnnotationFinder.findAnnotation(CT01.class.getMethod("method", null), Transaction01.class);
		boolean valid = AnnotationFinder.existAnnotation(CT01.class.getMethod("method", null), Transaction01.class);
		assertFalse(valid);
		

	}	
	
	// CT02
	public class CT02 {
		@Logging01 @Administration01
		public void method() {

		}
	}

	@Test
	public void CT02() throws NoSuchMethodException, AnnotationReadingException {

		List<Annotation> locatorList = AnnotationFinder.findAnnotation(CT02.class.getMethod("method", null), Transaction01.class);
		boolean valid = AnnotationFinder.existAnnotation(CT02.class.getMethod("method", null), Transaction01.class);
		Annotation an = locatorList.get(0);
		assertTrue(valid);
		assertTrue(an instanceof Transaction01);

	}
	
	// CT03 
	@Administration01
	public class CT03 {
		public void method() {

		}
	}

	@Test
	public void CT03() throws AnnotationReadingException {
		
		List<Annotation> locatorList = AnnotationFinder.findAnnotation(CT03.class, Transaction01.class);
		boolean valid = AnnotationFinder.existAnnotation(CT03.class, Transaction01.class);
		Annotation an = locatorList.get(0);
		assertTrue(valid);
		assertTrue(an instanceof Transaction01);
		
	}
	
	//CT04 
	@Test
	public void CT04() throws AnnotationReadingException {
		
		
		List<Annotation> locatorList = AnnotationFinder.findAnnotation(CT04.class.getPackage(), Transaction01.class);
		boolean valid = AnnotationFinder.existAnnotation(CT03.class, Transaction01.class);
		Annotation an = locatorList.get(0);
		assertTrue(valid);
		assertTrue(an instanceof Transaction01);

	
	}
	
	// CT05
	public class CT05 {
		@Administration02
		public void method() {

		}
	}

	@Test
	public void CT05() throws NoSuchMethodException, AnnotationReadingException {

		Annotation an = ml.findMetadata(CT05.class.getMethod("method", null), Transaction02.class);
		
		List<Annotation> locatorList = AnnotationFinder.findAnnotation(CT05.class.getMethod("method", null), Transaction02.class);
		boolean valid = AnnotationFinder.existAnnotation(CT05.class.getMethod("method", null), Transaction02.class);
		assertFalse(valid);


	}
	
	// CT06
	@Administration02
	public class CT06 {				
		public void method() {
		}
	}

	@Test
	public void CT06() throws AnnotationReadingException {
				
		List<Annotation> locatorList = AnnotationFinder.findAnnotation(CT06.class, Transaction02.class);
		boolean valid = AnnotationFinder.existAnnotation(CT06.class, Transaction02.class);
		assertFalse(valid);
	}	
	
	//CT07
	@Test
	public void CT07() throws AnnotationReadingException {
		Annotation an = ml.findMetadata(CT07.class.getPackage(), Transaction02.class);
		
		List<Annotation> locatorList = AnnotationFinder.findAnnotation(CT07.class.getPackage(), Transaction02.class);
		boolean valid = AnnotationFinder.existAnnotation(CT07.class.getPackage(), Transaction02.class);
		assertFalse(valid);

	}
	
	// CT08
	public class CT08 {
		@Administration03
		public void method() {

		}
	}

	@Test
	public void CT08() throws NoSuchMethodException, AnnotationReadingException {
			
		List<Annotation> locatorList = AnnotationFinder.findAnnotation(CT08.class.getMethod("method", null), Transaction03.class);
		boolean valid = AnnotationFinder.existAnnotation(CT08.class.getMethod("method", null), Transaction03.class);
		Annotation an = locatorList.get(0);
		assertTrue(valid);
		assertTrue(an instanceof Transaction03);
	}
	
	// CT09
	@Administration03
	public class CT09 {
		public void method() {

		}
	}

	@Test
	public void CT09() throws AnnotationReadingException {
			
		List<Annotation> locatorList = AnnotationFinder.findAnnotation(CT09.class, Transaction03.class);
		boolean valid = AnnotationFinder.existAnnotation(CT09.class, Transaction03.class);
		Annotation an = locatorList.get(0);
		assertTrue(valid);
		assertTrue(an instanceof Transaction03);

	}
	
	//CT10
	@Test
	public void CT10() throws AnnotationReadingException {

		List<Annotation> locatorList = AnnotationFinder.findAnnotation(CT10.class.getPackage(), Transaction03.class);
		boolean valid = AnnotationFinder.existAnnotation(CT10.class.getPackage(), Transaction03.class);
		Annotation an = locatorList.get(0);
		assertTrue(valid);
		
		assertTrue(an instanceof Transaction03);
	}

}
