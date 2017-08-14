package net.sf.esfinge.container.processor.method;

import static org.junit.Assert.assertNotSame;

import org.junit.Ignore;
import org.junit.Test;

import net.sf.esfinge.metadata.AnnotationReader;


public class ContainerProcessorsTest {

	@Test
	//@Ignore
	public void test() throws Exception {
		Container container = new Container();
		AnnotationReader a1 = new AnnotationReader();
		container = a1.readingAnnotationsTo(Dominio.class, container.getClass());
		//assertNotNull(container.getMap().size());
		assertNotSame(0, container.getMap().size());
		//assert();			
	}

}
