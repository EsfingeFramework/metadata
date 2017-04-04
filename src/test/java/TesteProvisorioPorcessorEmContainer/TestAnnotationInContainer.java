package TesteProvisorioPorcessorEmContainer;

import static org.junit.Assert.*;

import org.junit.Test;

import net.sf.esfinge.metadata.AnnotationReader;

public class TestAnnotationInContainer {

	@Test
	public void test() throws Exception {
		AnnotedContainer annotedContainer =  new AnnotedContainer();
		
		AnnotationReader ar = new AnnotationReader();
		annotedContainer = ar.readingAnnotationsTo(ElementWithAnnotation.class, annotedContainer.getClass());

		assertTrue(annotedContainer.isEnabled());
		assertEquals("TesteProvisorioPorcessorEmContainer.ElementWithAnnotation", annotedContainer.getClassName());
	}

}
