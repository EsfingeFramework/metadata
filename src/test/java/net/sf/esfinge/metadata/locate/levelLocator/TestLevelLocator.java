package net.sf.esfinge.metadata.locate.levelLocator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.lang.annotation.Annotation;
import java.util.List;

import net.sf.esfinge.metadata.AnnotationReadingException;
import org.junit.Test;

import net.sf.esfinge.metadata.AnnotationFinder;
import net.sf.esfinge.metadata.factory.LocatorsFactory;
import net.sf.esfinge.metadata.locate.EnclosingElementLocator;
import net.sf.esfinge.metadata.locate.MetadataLocator;
import net.sf.esfinge.metadata.locate.conventions.ForTesting;
import net.sf.esfinge.metadata.locate.levelLocator.CTAux1.CT02;
import net.sf.esfinge.metadata.locate.levelLocator.CTAux1.CT05;
import net.sf.esfinge.metadata.locate.levelLocator.CTAux1.CT07;
import net.sf.esfinge.metadata.locate.levelLocator.CTAux2.CT04;
import net.sf.esfinge.metadata.locate.levelLocator.CTAux2.CT06;
import net.sf.esfinge.metadata.locate.levelLocator.CTAux2.CT08;

public class TestLevelLocator {

	
	//CT01
	@TransactionSearchOnEnclosing
	public class CT01{	
		public String attribute;
		
	}
	
	@Test
	public void CT01() throws NoSuchFieldException, AnnotationReadingException {
		List<Annotation>  annList = AnnotationFinder.findAnnotation(CT01.class.getField("attribute"), TransactionSearchOnEnclosing.class);
		assertFalse(annList.isEmpty());
		assertTrue(annList.get(0) instanceof TransactionSearchOnEnclosing);
	}

	//CT02		
	@Test
	public void CT02() throws NoSuchFieldException, AnnotationReadingException {
		List<Annotation>  annList = AnnotationFinder.findAnnotation(CT02.class.getField("attribute"), TransactionSearchOnEnclosing.class);
		assertFalse(annList.isEmpty());
		assertTrue(annList.get(0) instanceof TransactionSearchOnEnclosing);
	}	
	
	//CT03
	@TransactionNoSearchEnclosing
	public class CT03{		
		public String attribute;
		
	}
	
	@Test 
	public void CT03() throws NoSuchFieldException, AnnotationReadingException {
		List<Annotation>  annList = AnnotationFinder.findAnnotation(CT03.class.getField("attribute"), TransactionNoSearchEnclosing.class);
		//Annotation an = locator.findMetadata(CT03.class.getField("attribute"), Transaction02.class);
		assertTrue(annList.isEmpty());
		//assertFalse(annList.get(0) instanceof Transaction02);
	}
	
	//CT04	
	@Test
	public void CT04() throws NoSuchFieldException, AnnotationReadingException {
		List<Annotation>  annList = AnnotationFinder.findAnnotation(CT04.class.getField("attribute"), TransactionNoSearchEnclosing.class);
		assertTrue(annList.isEmpty());
		//assertFalse(an instanceof Transaction02);
	}	
	
	//CT05		
	@Test
	public void CT05() throws NoSuchFieldException, AnnotationReadingException {
		List<Annotation>  annList = AnnotationFinder.findAnnotation(CT05.class, TransactionSearchOnEnclosing.class);
		assertFalse(annList.isEmpty());
		assertTrue(annList.get(0) instanceof TransactionSearchOnEnclosing);
	}	

	//CT06	
	@Test
	public void CT06() throws NoSuchFieldException, AnnotationReadingException {
		List<Annotation>  annList = AnnotationFinder.findAnnotation(CT06.class, TransactionNoSearchEnclosing.class);
		assertTrue(annList.isEmpty());
		//assertFalse(an instanceof Transaction02);
	}		
	
	//CT07	
	@Test
	public void CT07() throws NoSuchMethodException, AnnotationReadingException {
		List<Annotation>  annList = AnnotationFinder.findAnnotation(CT07.class.getMethod("method", null), TransactionSearchOnEnclosing.class);
		assertFalse(annList.isEmpty());
		assertTrue(annList.get(0) instanceof TransactionSearchOnEnclosing);
	}

	//CT08
	@Test
	public void CT08() throws NoSuchMethodException, AnnotationReadingException {
		List<Annotation>  annList = AnnotationFinder.findAnnotation(CT08.class.getMethod("method", null), TransactionNoSearchEnclosing.class);
		assertTrue(annList.isEmpty());
		//assertFalse(an instanceof Transaction02);
	}
	
	//CT09
	@TransactionSearchOnEnclosing
	public class CT09{		
		public void method(){
			//method implementation
		}		
	}
	
	@Test
	public void CT09() throws NoSuchMethodException, AnnotationReadingException {
		List<Annotation>  annList = AnnotationFinder.findAnnotation(CT09.class.getMethod("method",null), TransactionSearchOnEnclosing.class);
		assertFalse(annList.isEmpty());
		assertTrue(annList.get(0) instanceof TransactionSearchOnEnclosing);
	}
	
	//CT10
	@TransactionNoSearchEnclosing
	public class CT10{		
		public void method(){
			//method implementation
		}		
	}
	
	@Test
	public void CT10() throws NoSuchMethodException, AnnotationReadingException {
		List<Annotation>  annList = AnnotationFinder.findAnnotation(CT10.class.getMethod("method"), TransactionNoSearchEnclosing.class);
		//Annotation an = 
		assertTrue(annList.isEmpty());
		//assertFalse(annList.get(0) instanceof Transaction02);
	}	
	
	//CT11	
	public class CT11{		
		public String attribute;
		
	}
	
	@Test
	public void CT11() throws NoSuchFieldException, AnnotationReadingException {
		List<Annotation>  annList = AnnotationFinder.findAnnotation(CT11.class, TransactionNoSearchEnclosing.class);
		assertTrue(annList.isEmpty());
	}	
		
	
}
