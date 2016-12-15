package testMethodReading;

import static org.junit.Assert.*;

import org.junit.Test;

import testMethodReading.Dominio;
import net.sf.esfinge.metadata.AnnotationReader;

public class TestMethodsReading {

	@Test
	public void test() throws Exception {
		AnnotationReader ann = new AnnotationReader();
		
		Container ct = ann.readingAnnotationsTo(Dominio.class, Container.class);
		
		assertEquals(1,ct.getMethodContainerProcess().size());
		assertEquals(1, ct.getMethodContainerWinouthAnnotation().size());
	}
	@Test
	public void test2() throws Exception {
		AnnotationReader ann = new AnnotationReader();
		
		Container ct = ann.readingAnnotationsTo(Dominio2.class, Container.class);
		
		assertEquals(1,ct.getMethodContainerProcess().size());
		assertEquals(3, ct.getMethodContainerWinouthAnnotation().size());
	}
	@Test
	public void test3() throws Exception {
		AnnotationReader ann = new AnnotationReader();
		
		Container ct = ann.readingAnnotationsTo(Dominio3.class, Container.class);
		
		assertEquals(3,ct.getMethodContainerProcess().size());
		assertEquals(1, ct.getMethodContainerWinouthAnnotation().size());
	}
	
	@Test
	public void test4() throws Exception {
		AnnotationReader ann = new AnnotationReader();
		
		Container ct = ann.readingAnnotationsTo(Dominio4.class, Container.class);
		
		assertEquals(0,ct.getMethodContainerProcess().size());
		assertEquals(4, ct.getMethodContainerWinouthAnnotation().size());
	}
	@Test
	public void test5() throws Exception {
		AnnotationReader ann = new AnnotationReader();
		
		Container ct = ann.readingAnnotationsTo(Dominio5.class, Container.class);
		
		assertEquals(4,ct.getMethodContainerProcess().size());
		assertEquals(0, ct.getMethodContainerWinouthAnnotation().size());
	}


}
