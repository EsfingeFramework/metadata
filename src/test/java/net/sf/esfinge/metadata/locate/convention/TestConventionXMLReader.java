package net.sf.esfinge.metadata.locate.convention;

import static org.junit.Assert.*;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

import net.sf.esfinge.metadata.locate.convention.finder.ConventionsXMLReader;
import net.sf.esfinge.metadata.locate.convention.processor.ContainsConventionProcessor;
import net.sf.esfinge.metadata.locate.convention.processor.PosfixConventionProcessor;
import net.sf.esfinge.metadata.locate.convention.processor.PrefixConventionProcessor;

public class TestConventionXMLReader {
	
	
	@BeforeClass
	public static void configProcessors(){
		ConventionsXMLReader.addProcessor(PosfixConventionProcessor.class);
		ConventionsXMLReader.addProcessor(PrefixConventionProcessor.class);
		ConventionsXMLReader.addProcessor(ContainsConventionProcessor.class);
	}
	
	@Test
	public void readXMLWithOneAnnotation(){
		ConventionsXMLReader reader = new ConventionsXMLReader();
		reader.read(new File("conventionsExample.xml"));
		assertTrue(reader.getProcessors().containsKey(ExampleXML.class));
		assertTrue(reader.getProcessors().get(ExampleXML.class).get(0) instanceof PosfixConventionProcessor);
		assertEquals("example",((PosfixConventionProcessor)reader.getProcessors().get(ExampleXML.class).get(0)).getName());
		
	}
	
	@Test
	public void readXMLWithPrefixConvention(){
		ConventionsXMLReader reader = new ConventionsXMLReader();
		reader.read(new File("conventionsExample.xml"));
		assertTrue(reader.getProcessors().containsKey(ExampleXML.class));
		assertTrue(reader.getProcessors().get(ExampleXML.class).get(1) instanceof PrefixConventionProcessor);
		assertEquals("test",((PrefixConventionProcessor)reader.getProcessors().get(ExampleXML.class).get(1)).getName());
		
	}
	
	@Test
	public void readXMLWithContainsConvention(){
		ConventionsXMLReader reader = new ConventionsXMLReader();
		reader.read(new File("conventionsExample.xml"));
		assertTrue(reader.getProcessors().containsKey(ExampleXML.class));
		assertTrue(reader.getProcessors().get(ExampleXML.class).get(2) instanceof ContainsConventionProcessor);
		assertEquals("testing",((ContainsConventionProcessor)reader.getProcessors().get(ExampleXML.class).get(2)).getName());
		
	}
	
	@Test
	public void readXMLWithTwoAnnotations(){
		ConventionsXMLReader reader = new ConventionsXMLReader();
		reader.read(new File("conventionsExample.xml"));
		assertTrue(reader.getProcessors().containsKey(ExampleXML.class));
		assertTrue(reader.getProcessors().get(ExampleXML.class).get(0) instanceof PosfixConventionProcessor);
		assertTrue(reader.getProcessors().get(ExampleXML.class).get(2) instanceof ContainsConventionProcessor);
		assertEquals("example",((PosfixConventionProcessor)reader.getProcessors().get(ExampleXML.class).get(0)).getName());
		assertEquals("testing",((ContainsConventionProcessor)reader.getProcessors().get(ExampleXML.class).get(2)).getName());
		
	}
	
	@Test
	public void readXMLWithTwoAnnotationsSameType(){
		ConventionsXMLReader reader = new ConventionsXMLReader();
		reader.read(new File("conventionsExample.xml"));
		assertTrue(reader.getProcessors().containsKey(ExampleXML.class));
		assertTrue(reader.getProcessors().get(ExampleXML.class).get(0) instanceof PosfixConventionProcessor);
		assertTrue(reader.getProcessors().get(ExampleXML.class).get(3) instanceof PosfixConventionProcessor);
		assertEquals("example",((PosfixConventionProcessor)reader.getProcessors().get(ExampleXML.class).get(0)).getName());
		assertEquals("anotherExample",((PosfixConventionProcessor)reader.getProcessors().get(ExampleXML.class).get(3)).getName());
		
	}

}
