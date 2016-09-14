package net.sf.esfinge.container.processor.clazz;

import static org.junit.Assert.*;

import java.lang.annotation.Annotation;
import java.util.List;

import org.junit.Test;

import net.sf.esfinge.metadata.AnnotationFinder;
import net.sf.esfinge.metadata.AnnotationReader;
import net.sf.esfinge.metadata.annotation.container.Processors;
import net.sf.esfinge.metadata.locate.MetadataLocator;
import net.sf.esfinge.metadata.validate.MetadataValidator;


public class ContainerProcessorsTest {

	@Test
	public void testContainerForClass() throws Exception {
		Container container = new Container();
		AnnotationReader a1 = new AnnotationReader();
		container = a1.readingAnnotationsTo(Dominio.class, container.getClass());
		assertNotNull(container.getList().size());
		assertEquals(1,container.getList().size());
		//assert();			
	}
	
	@Test
	public void pv() {
		
		Container container = new Container();
		
		
	}

}
