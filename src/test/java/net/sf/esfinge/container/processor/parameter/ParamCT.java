package net.sf.esfinge.container.processor.parameter;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;
import net.sf.esfinge.metadata.AnnotationReader;

public class ParamCT {

	@Test
	public void Ct01() throws Exception {
		
		ContainerClazz container = new ContainerClazz();
		AnnotationReader a1 = new AnnotationReader();
		
		container = a1.readingAnnotationsTo(Dominio.class, container.getClass());
		assertEquals(2,container.getMethodContainer().size());
		
		assertEquals("arg0", container.getMethodWithAnn().get(0).getParameters().get(0).getParameterName());	

	}

}
