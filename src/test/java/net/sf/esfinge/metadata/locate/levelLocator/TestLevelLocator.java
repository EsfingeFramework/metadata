package net.sf.esfinge.metadata.locate.levelLocator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.lang.annotation.Annotation;
import java.util.List;

import org.junit.Test;

import net.sf.esfinge.metadata.AnnotationFinder;
import net.sf.esfinge.metadata.locate.EnclosingElementLocator;
import net.sf.esfinge.metadata.locate.levelLocator.CTAux1.CT02;
import net.sf.esfinge.metadata.locate.levelLocator.CTAux1.CT05;
import net.sf.esfinge.metadata.locate.levelLocator.CTAux1.CT07;
import net.sf.esfinge.metadata.locate.levelLocator.CTAux2.CT04;
import net.sf.esfinge.metadata.locate.levelLocator.CTAux2.CT06;
import net.sf.esfinge.metadata.locate.levelLocator.CTAux2.CT08;

public class TestLevelLocator {
	private EnclosingElementLocator locator = new EnclosingElementLocator();
	
	//CT01
	@Transaction01
	public class CT01{	
		public String attribute;
		
	}
	
	@Test
	public void CT01()throws NoSuchFieldException{
		List<Annotation>  annList = AnnotationFinder.findAnnotation(CT01.class.getField("attribute"), Transaction01.class);
		assertFalse(annList.isEmpty());
		assertTrue(annList.get(0) instanceof Transaction01);
	}

	//CT02		
	@Test
	public void CT02()throws NoSuchFieldException{
		List<Annotation>  annList = AnnotationFinder.findAnnotation(CT02.class.getField("attribute"), Transaction01.class);
		assertFalse(annList.isEmpty());
		assertTrue(annList.get(0) instanceof Transaction01);
	}	
	
	//CT03
	@Transaction02
	public class CT03{		
		public String attribute;
		
	}
	
	@Test 
	public void CT03()throws NoSuchFieldException{
		List<Annotation>  annList = AnnotationFinder.findAnnotation(CT03.class.getField("attribute"), Transaction02.class);
		//Annotation an = locator.findMetadata(CT03.class.getField("attribute"), Transaction02.class);
		assertTrue(annList.isEmpty());
		//assertFalse(annList.get(0) instanceof Transaction02);
	}
	
	//CT04	
	@Test
	public void CT04()throws NoSuchFieldException{
		List<Annotation>  annList = AnnotationFinder.findAnnotation(CT04.class.getField("attribute"), Transaction02.class);
		assertTrue(annList.isEmpty());
		//assertFalse(an instanceof Transaction02);
	}	
	
	//CT05		
	@Test
	public void CT05()throws NoSuchFieldException{
		List<Annotation>  annList = AnnotationFinder.findAnnotation(CT05.class, Transaction01.class);
		assertFalse(annList.isEmpty());
		assertTrue(annList.get(0) instanceof Transaction01);
	}	

	//CT06	
	@Test
	public void CT06()throws NoSuchFieldException{
		List<Annotation>  annList = AnnotationFinder.findAnnotation(CT06.class, Transaction02.class);
		assertTrue(annList.isEmpty());
		//assertFalse(an instanceof Transaction02);
	}		
	
	//CT07	
	@Test
	public void CT07()throws NoSuchMethodException{
		List<Annotation>  annList = AnnotationFinder.findAnnotation(CT07.class.getMethod("method", null), Transaction01.class);
		assertFalse(annList.isEmpty());
		assertTrue(annList.get(0) instanceof Transaction01);
	}

	//CT08
	@Test
	public void CT08()throws NoSuchMethodException{
		List<Annotation>  annList = AnnotationFinder.findAnnotation(CT08.class.getMethod("method", null), Transaction02.class);
		assertTrue(annList.isEmpty());
		//assertFalse(an instanceof Transaction02);
	}
	
	//CT09
	@Transaction01
	public class CT09{		
		public void method(){
			//method implementation
		}		
	}
	
	@Test
	public void CT09()throws NoSuchMethodException{
		List<Annotation>  annList = AnnotationFinder.findAnnotation(CT09.class.getMethod("method",null), Transaction01.class);
		assertFalse(annList.isEmpty());
		assertTrue(annList.get(0) instanceof Transaction01);
	}
	
	//CT10
	@Transaction02
	public class CT10{		
		public void method(){
			//method implementation
		}		
	}
	
	@Test
	public void CT10()throws NoSuchMethodException{
		List<Annotation>  annList = AnnotationFinder.findAnnotation(CT10.class.getMethod("method"), Transaction02.class);
		//Annotation an = 
		assertTrue(annList.isEmpty());
		//assertFalse(annList.get(0) instanceof Transaction02);
	}	
	
	//CT11	
	public class CT11{		
		public String attribute;
		
	}
	
	@Test
	public void CT11()throws NoSuchFieldException{
		List<Annotation>  annList = AnnotationFinder.findAnnotation(CT11.class, Transaction02.class);
		assertTrue(annList.isEmpty());
	}	
		
	
}
