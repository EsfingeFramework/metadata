package net.sf.esfinge.metadata.properties;

import static net.sf.esfinge.classmock.ClassMockUtils.set;
import static org.junit.Assert.*;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.apache.commons.collections.functors.IfClosure;
import org.junit.Before;
import org.junit.Test;

import net.sf.esfinge.classmock.ClassMock;
import net.sf.esfinge.metadata.properties.containers.*;
import net.sf.esfinge.metadata.properties.elements.IgnoraInterno;
import net.sf.esfinge.metadata.properties.elements.IgnoreOneField;
import net.sf.esfinge.metadata.properties.elements.IgnoreOneFieldAndReturnTwo;
import net.sf.esfinge.metadata.properties.elements.PropertyEmpty;
import net.sf.esfinge.metadata.properties.elements.WinouthIgnore;
import net.sf.esfinge.metadata.AnnotationFinder;
import net.sf.esfinge.metadata.AnnotationReader;
import net.sf.esfinge.metadata.locate.AnnotationLocator;
import net.sf.esfinge.metadata.properties.annotation.IgnoreInComparison;
import net.sf.esfinge.metadata.properties.annotation.IgnoreInc;

public class PropiertiesIgnoreTest {
	
	@Test
	public void testNull() throws Exception {
		
		AnnotationReader ar = new AnnotationReader();
		
		ContainerIgnore container = ar.readingAnnotationsTo(PropertyEmpty.class, ContainerIgnore.class);
		
		assertTrue(container.getProperties().isEmpty());
		
	}
	

	@Test
	public void testSemOIgnore() throws Exception {
		AnnotationReader ar = new AnnotationReader();
		
		ContainerIgnore container = ar.readingAnnotationsTo(WinouthIgnore.class, ContainerIgnore.class);
		
		assertFalse(container.getProperties().isEmpty());
		assertEquals("prop1", container.getProperties().get(0).getName());
		
	}
	
	@Test
	public void testIgnorandoUmField() throws Exception {
		AnnotationReader ar = new AnnotationReader();
		
		ContainerIgnore container = ar.readingAnnotationsTo(IgnoreOneField.class, ContainerIgnore.class);

		
		assertFalse(container.getProperties().isEmpty());
		assertEquals(1, container.getProperties().size());
		assertEquals("prop2", container.getProperties().get(0).getName());

	}

	@Test
	public void testIgnorandoUmObjetoeRetronaDois() throws Exception {
		
		AnnotationReader ar = new AnnotationReader();
		
		ContainerIgnore containerIgnore = ar.readingAnnotationsTo(IgnoreOneFieldAndReturnTwo.class, ContainerIgnore.class);

		
		assertFalse(containerIgnore.getProperties().isEmpty());
		assertEquals(2, containerIgnore.getProperties().size());
		assertEquals("prop2", containerIgnore.getProperties().get(0).getName());
		assertEquals("prop3", containerIgnore.getProperties().get(1).getName());

	}

	
	@Test
	public void testIgnoraInterno() throws Exception {

		
		
		
		AnnotationReader ar = new AnnotationReader();
		ContainerIgnore containerIgnore = new ContainerIgnore();
		containerIgnore = ar.readingAnnotationsTo(IgnoraInterno.class, containerIgnore.getClass());
		
		assertFalse(containerIgnore.getProperties().isEmpty());
		assertEquals(1, containerIgnore.getProperties().size());
		assertEquals("prop2", containerIgnore.getProperties().get(0).getName());


	}


}
