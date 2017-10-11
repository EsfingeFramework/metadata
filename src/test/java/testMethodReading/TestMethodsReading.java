package testMethodReading;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import net.sf.esfinge.metadata.AnnotationReader;
import net.sf.esfinge.metadata.container.MetadataRepository;

public class TestMethodsReading {
	
	@Before
	public void destroyAnnotation() throws Exception
	{
		MetadataRepository.destroyRepository();
	}

	@Test
	public void test() throws Exception {
		AnnotationReader ann = new AnnotationReader();
		
		ContainerEX1 ct = ann.readingAnnotationsTo(Dominio.class, ContainerEX1.class);
		
		assertEquals(1,ct.getMethodContainerProcess().size());
		assertEquals(1, ct.getMethodContainerWinouthAnnotation().size());
	}
	@Test
	public void test2() throws Exception {
		AnnotationReader ann = new AnnotationReader();
		
		ContainerEX1 ct = ann.readingAnnotationsTo(Dominio2.class, ContainerEX1.class);
		
		assertEquals(1,ct.getMethodContainerProcess().size());
		assertEquals(3, ct.getMethodContainerWinouthAnnotation().size());
	}
	@Test
	public void test3() throws Exception {
		AnnotationReader ann = new AnnotationReader();
		
		ContainerEX1 ct = ann.readingAnnotationsTo(Dominio3.class, ContainerEX1.class);
		
		assertEquals(3,ct.getMethodContainerProcess().size());
		assertEquals(1, ct.getMethodContainerWinouthAnnotation().size());
	}
	
	@Test
	public void test4() throws Exception {
		AnnotationReader ann = new AnnotationReader();
		
		ContainerEX1 ct = ann.readingAnnotationsTo(Dominio4.class, ContainerEX1.class);
		
		assertEquals(0,ct.getMethodContainerProcess().size());
		assertEquals(4, ct.getMethodContainerWinouthAnnotation().size());
	}
	@Test
	public void test5() throws Exception {
		AnnotationReader ann = new AnnotationReader();
		
		ContainerEX1 ct = ann.readingAnnotationsTo(Dominio5.class, ContainerEX1.class);
		
		assertEquals(4,ct.getMethodContainerProcess().size());
		assertEquals(0, ct.getMethodContainerWinouthAnnotation().size());
	}


}
