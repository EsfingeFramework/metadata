package org.esfinge.metadata.container;

import static org.junit.Assert.*;

import org.esfinge.metadata.container.ContainerMetadados;
import org.esfinge.metadata.container.LeitorMetadados;
import org.junit.Test;

public class TestLeitorMetadados {
	
	@Test
	public void TestBoolean(){
		LeitorMetadados lm = new LeitorMetadados();
		ContainerMetadados container = lm.lerMetadados(DummyClass.class);
		
		assertTrue(container.getValue("FindMe").getHasAnnotation());
	}
}
