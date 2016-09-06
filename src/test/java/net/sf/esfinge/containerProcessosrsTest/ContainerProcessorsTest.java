package net.sf.esfinge.containerProcessosrsTest;

import static org.junit.Assert.*;

import org.junit.Test;

import net.sf.esfinge.metadata.AnnotationReader;


public class ContainerProcessorsTest {

	@Test
	public void test() {
		Container container = new Container();
		AnnotationReader a1 = new AnnotationReader();
		try {
			container = a1.readingAnnotationsTo(Dominio.class, container.getClass());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
