package org.esfinge.metadata.locate.levelLocator;

import static org.junit.Assert.*;
import java.lang.annotation.Annotation;
import org.esfinge.metadata.AnnotationFinder;
import org.esfinge.metadata.locate.levelLocator.CT02.CT02;
import org.esfinge.metadata.locate.levelLocator.CT02.CT05;
import org.esfinge.metadata.locate.levelLocator.CT02.CT07;
import org.esfinge.metadata.locate.levelLocator.CT04.CT04;
import org.esfinge.metadata.locate.levelLocator.CT04.CT06;
import org.esfinge.metadata.locate.levelLocator.CT04.CT08;
import org.junit.Test;

public class TestLevelLocator {	
	//CT01
	@Transaction01
	public class CT01{		
		public String attribute;
		
	}
	
	@Test
	public void CT01()throws NoSuchFieldException{
		Annotation an = AnnotationFinder.findAnnotation(CT01.class.getField("attribute"), Transaction01.class);
		assertNotNull(an);
		assertTrue(an instanceof Transaction01);
	}

	//CT02		
	@Test
	public void CT02()throws NoSuchFieldException{
		Annotation an = AnnotationFinder.findAnnotation(CT02.class.getField("attribute"), Transaction01.class);
		assertNotNull(an);
		assertTrue(an instanceof Transaction01);
	}	
	
	//CT03
	@Transaction02
	public class CT03{		
		public String attribute;
		
	}
	
	@Test 
	public void CT03()throws NoSuchFieldException{
		Annotation an = AnnotationFinder.findAnnotation(CT03.class.getField("attribute"), Transaction02.class);
		assertNull(an);
		assertFalse(an instanceof Transaction02);
	}
	
	//CT04	
	@Test
	public void CT04()throws NoSuchFieldException{
		Annotation an = AnnotationFinder.findAnnotation(CT04.class.getField("attribute"), Transaction02.class);
		assertNull(an);
		assertFalse(an instanceof Transaction02);
	}	
	
	//CT05		
	@Test
	public void CT05()throws NoSuchFieldException{
		Annotation an = AnnotationFinder.findAnnotation(CT05.class, Transaction01.class);
		assertNotNull(an);
		assertTrue(an instanceof Transaction01);
	}	

	//CT06	
	@Test
	public void CT06()throws NoSuchFieldException{
		Annotation an = AnnotationFinder.findAnnotation(CT06.class, Transaction02.class);
		assertNull(an);
		assertFalse(an instanceof Transaction02);
	}		
	
	//CT07	
	@Test
	public void CT07()throws NoSuchMethodException{
		Annotation an = AnnotationFinder.findAnnotation(CT07.class.getMethod("method", null), Transaction01.class);
		assertNotNull(an);
		assertTrue(an instanceof Transaction01);
	}

	//CT08
	@Test
	public void CT08()throws NoSuchMethodException{
		Annotation an = AnnotationFinder.findAnnotation(CT08.class.getMethod("method", null), Transaction02.class);
		assertNull(an);
		assertFalse(an instanceof Transaction02);
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
		Annotation an = AnnotationFinder.findAnnotation(CT09.class.getMethod("method",null), Transaction01.class);
		assertNotNull(an);
		assertTrue(an instanceof Transaction01);
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
		Annotation an = AnnotationFinder.findAnnotation(CT10.class.getMethod("method",null), Transaction02.class);
		assertNull(an);
		assertFalse(an instanceof Transaction02);
	}	
	
	//CT11	
	public class CT11{		
		public String attribute;
		
	}
	
	@Test
	public void CT11()throws NoSuchFieldException{
		Annotation an = AnnotationFinder.findAnnotation(CT11.class, Transaction02.class);
		assertNull(an);
		assertFalse(an instanceof Transaction02);
	}	
		
	
}
