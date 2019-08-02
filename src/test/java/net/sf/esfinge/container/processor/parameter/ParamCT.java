package net.sf.esfinge.container.processor.parameter;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;
import net.sf.esfinge.metadata.AnnotationReader;

public class ParamCT {
	ContainerClazz container = new ContainerClazz();
	AnnotationReader a1 = new AnnotationReader();
	
	@Before
	public void before() throws Exception
	{
		
		container = a1.readingAnnotationsTo(Dominio.class, container.getClass());
	}
	
	@Test
	public void Ct01() throws Exception {
		
		
		assertEquals(2,container.getMethodContainer().size());
		
		assertEquals("arg0", container.getMethodWithAnn().get(0).getParameters().get(0).getParameterName());	

	}
	@Test
	public void Ct02() throws Exception {
		
		
		assertEquals(2,container.getMethodContainer().size());
		
		ParameterContainer validate = container.getMethodWithAnn().get(0).getParameters().get(0);
		
		assertEquals("int", validate.getParameter().getType().getName());	
		assertEquals("arg0",validate.getParameter().getName());

	}

}
