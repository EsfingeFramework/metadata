package net.sf.esfinge.container.processor.Field;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import net.sf.esfinge.metadata.AnnotationReader;


public class ContainerProcessorsTest {

	@Test
	public void test() throws Exception {
		ContainerMapField container = new ContainerMapField();
		AnnotationReader a1 = new AnnotationReader();
		container = a1.readingAnnotationsTo(Dominio.class, container.getClass());
		
		assertNotNull(container.getMap());
		
		//assert();			
	}

}
