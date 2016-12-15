package net.sf.esfinge.metadata.properties;

import static org.junit.Assert.*;

import org.junit.Test;

import net.sf.esfinge.container.processor.method.DominioSegundo;
import net.sf.esfinge.container.processor.method.ProcessorInterface;
import net.sf.esfinge.metadata.properties.containers.*;
import net.sf.esfinge.metadata.properties.elements.ValidElement;
import net.sf.esfinge.metadata.AnnotationReader;

public class PropiertiesExecute {
	
	@Test
	public void testExecProperty() throws Exception {
		
		AnnotationReader ar = new AnnotationReader();
		
		ContainerIgnore container = ar.readingAnnotationsTo(ValidElement.class, ContainerIgnore.class);
		
		
		assertFalse(container.getProperties().isEmpty());
		assertEquals(2, container.getProperties().size());
		
		for(PropertyDescriptorAnnoted x : container.getProperties())
		{
			for (ProcessorInterface xx:x.getM1()) {
				assertEquals(DominioSegundo.class,xx.getClass());
			}
		}
		
	}
	




}
