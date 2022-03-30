package net.sf.esfinge.container.processor.clazz;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import net.sf.esfinge.container.processor.clazz.ct01.Container;
import net.sf.esfinge.container.processor.clazz.ct01.Dominio;
import net.sf.esfinge.container.processor.clazz.ct01.DominioSegundo;
import net.sf.esfinge.container.processor.clazz.ct01.ProcessorInterface;
import net.sf.esfinge.metadata.AnnotationReader;


public class ContainerProcessorsTest {

	@Test
	public void testContainerForClass() throws Exception {
		Container container = new Container();
		AnnotationReader a1 = new AnnotationReader();

		container = a1.readingAnnotationsTo(Dominio.class, container.getClass());
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
	
	//@Test
	//public void testClassIntern() throws Exception{
	//	
	//	ContainerNotNull container = new ContainerNotNull();
	//	AnnotationReader a1 = new AnnotationReader();
	//	container = a1.readingAnnotationsTo(DomMaxValue.class, container.getClass());
	//	
	//	assertEquals(1,container.getLista().size());
		
		

		
	//}

}
