package net.sf.esfinge.container.processor.clazz;

import static org.junit.Assert.*;

import java.lang.annotation.Annotation;
import java.util.List;

import org.junit.Test;

import net.sf.esfinge.container.processor.clazz.ct01.Container;
import net.sf.esfinge.container.processor.clazz.ct01.Dominio;
import net.sf.esfinge.container.processor.clazz.ct01.DominioSegundo;
import net.sf.esfinge.container.processor.clazz.ct01.ProcessorInterface;
import net.sf.esfinge.container.processor.clazz.maxvalue.ContainerNotNull;
import net.sf.esfinge.container.processor.clazz.maxvalue.DomMaxValue;
import net.sf.esfinge.container.processor.clazz.maxvalue.PointsToUser;
import net.sf.esfinge.metadata.AnnotationFinder;
import net.sf.esfinge.metadata.AnnotationPropertyValidator;
import net.sf.esfinge.metadata.AnnotationReader;
import net.sf.esfinge.metadata.annotation.container.Processors;
import net.sf.esfinge.metadata.annotation.validator.NotNull;
import net.sf.esfinge.metadata.locate.LevelLocator;
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
		for (ProcessorInterface iterable : container.getList()) {
			if(iterable.getClass().equals(DominioSegundo.class))
			{
				assertTrue(iterable.getClass().equals(DominioSegundo.class));
			}
			else{
				assertEquals(true, iterable.getClass().equals(DominioSegundo.class));
			}
		}

		
	}
	
	@Test
	public void containerMaxValue() throws Exception{
		ContainerNotNull mv = new ContainerNotNull();
		AnnotationReader a1 = new AnnotationReader();
		
		mv = a1.readingAnnotationsTo(DomMaxValue.class, mv.getClass());
		System.out.println("SIZE");
		System.out.println(mv.getLista().size());
	}

}
