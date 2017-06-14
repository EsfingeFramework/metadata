package TestCustonReaderAnnoted;

import static org.junit.Assert.*;

import org.junit.Test;

import TestCustonReaderAnnoted.data.ClassWithMetadata;
import net.sf.esfinge.metadata.AnnotationReader;

public class ProcessorWithContainerTest {


	@Test
	public void validAnnotation() throws Exception {
		AnnotationReader ar = new AnnotationReader();
		
		Container ct = new Container();
		
		ct = ar.readingAnnotationsTo(ClassWithMetadata.class, Container.class);
		
		ExecuteProcessors processor  =(ExecuteProcessors) ct.getInterf().get(0);
		
		assertTrue(processor.isExistAnnotation());
		
		
		
	}

}
