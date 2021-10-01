package net.sf.esfinge.metadata.locate.conventions.mapping;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import net.sf.esfinge.metadata.AnnotationReader;

public class TestConventionsWithMapping {

	@Test
	public void conventionsWithMapping() throws Exception {
		AnnotationReader reader = new AnnotationReader();
		
		ContainerClass c1 = reader.readingAnnotationsTo(ExampleClass.class, ContainerClass.class);
		assertTrue(c1.isSecure());
		
		ContainerClass c2 = reader.readingAnnotationsTo(ClassWithoutAnything.class, ContainerClass.class);
		assertFalse(c2.isSecure());
		
		ContainerClass c3 = reader.readingAnnotationsTo(ClassLocked.class, ContainerClass.class);
		assertTrue(c3.isSecure());
	}

}
