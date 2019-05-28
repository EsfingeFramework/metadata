package net.sf.esfinge.metadata.locate.convention;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import net.sf.esfinge.classmock.*;
import net.sf.esfinge.metadata.locate.MetadataLocationException;

public class TestConventionLocator {
	private ConventionLocator locator = new ConventionLocator();	
	private ClassMock mockClass;
	
    @Before
    public void createMockClass(){
        mockClass = new ClassMock("ExampleClassMock");
        mockClass.addProperty("name", String.class)
        .addProperty("userID", int.class);
		mockClass.addMethod(int.class, "method");
    }
	
	@Test
	public void withoutAnnotationTest() {
		Class<?> mock = mockClass.createClass();
		assertFalse(locator.findMetadata(mock, Finder.class));
	}
	
	
	@Test
	public void withAnnotation() {
		mockClass.addAnnotation(Finder.class, "Finder");
    	Class<?> mock = mockClass.createClass();
		assertTrue(locator.findMetadata(mock, Finder.class));
	}
	
	@Test
	public void withoutAnnotationInMethod() throws MetadataLocationException, NoSuchMethodException, SecurityException {
		Class<?> mock = mockClass.createClass();
		assertFalse(locator.findMetadata(mock.getMethod("method", null), Finder.class));
	}
	
	
	@Test
	public void withAnnotationInMethod() throws MetadataLocationException, NoSuchMethodException, SecurityException {
		mockClass.addMethodAnnotation("method", Finder.class);
		Class mock = mockClass.createClass();
		assertTrue(locator.findMetadata(mock.getMethod("method"), Finder.class));
	}
	
	@Test
	public void withoutAnnotationInPrefixConvetion() throws MetadataLocationException, NoSuchMethodException, SecurityException {
		Class mock = mockClass.createClass();
		assertFalse(locator.findMetadata(mock.getMethod("method", null), Finder.class));
	}
	
	@Test
	public void withAnnotationInPrefixConvetion() throws MetadataLocationException, NoSuchMethodException, SecurityException {
		mockClass.addMethod(Object.class, "searchSomething");
		Class mock = mockClass.createClass();
		assertTrue(locator.findMetadata(mock.getMethod("searchSomething", null), Search.class));
	}
	
	@Test
	public void withAnnotationInPosfixConvetion() throws MetadataLocationException, NoSuchMethodException, SecurityException {
		mockClass.addMethod(String.class, "inTheEndExample");
		Class mock = mockClass.createClass();
		assertTrue(locator.findMetadata(mock.getMethod("inTheEndExample", null), Example.class));
	}
	
	@Test
	public void withAnnotationContainsConvention() throws MetadataLocationException,  SecurityException, NoSuchFieldException {
		Class mock = mockClass.createClass();		
		assertTrue(locator.findMetadata(mock.getDeclaredField("userID"), ID.class));
	}
	
}
