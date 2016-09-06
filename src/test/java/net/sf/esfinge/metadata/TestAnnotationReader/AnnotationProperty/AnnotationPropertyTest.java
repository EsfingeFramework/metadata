package net.sf.esfinge.metadata.TestAnnotationReader.AnnotationProperty;

import static org.junit.Assert.*;

import java.lang.annotation.Annotation;

import org.junit.Test;

import net.sf.esfinge.metadata.AnnotationReader;

public class AnnotationPropertyTest {

	@Test
	public void test() throws Exception {
		Container ct = new Container();
		
		AnnotationReader reader = new AnnotationReader();
		ct = reader.readingAnnotationsTo(Dominio.class, ct.getClass());
		System.out.println(ct.getNomeTabela().toString());
		assertEquals(Dominio.class, ct.getNomeTabela());
	}

}
