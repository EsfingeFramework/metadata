package net.sf.esfinge.metadata.locate.convention.finder;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import net.sf.esfinge.metadata.locate.convention.ConventionProcessor;
import net.sf.esfinge.metadata.locate.convention.ConventionXMLTag;
import net.sf.jColtrane.annotations.args.Attribute;
import net.sf.jColtrane.annotations.args.AttributeMap;
import net.sf.jColtrane.annotations.args.Tag;
import net.sf.jColtrane.annotations.methods.BeforeElement;
import net.sf.jColtrane.annotations.methods.EndElement;
import net.sf.jColtrane.annotations.methods.StartElement;
import net.sf.jColtrane.handler.JColtraneXMLHandler;

public class ConventionsXMLReader {
	
	private static Map<String, Class<? extends ConventionProcessor>> processorMap = new HashMap<>();
	
	public static void addProcessor(Class<? extends ConventionProcessor> processorClass){
		String tag =  processorClass.getAnnotation(ConventionXMLTag.class).value();
		processorMap.put(tag, processorClass);
	}

	Map<Class<?>, List<ConventionProcessor>> processors = new HashMap<>();
	
	Class<?> currentClass = null;

	public Map<Class<?>, List<ConventionProcessor>> getProcessors() {
		return processors;
	}

	public void read(File file) {
		try {
			SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
			if (parser != null) {
				InputSource input = new InputSource(file.getAbsolutePath());
				parser.parse(input, new JColtraneXMLHandler(this));
			}
		} catch (ParserConfigurationException | SAXException | IOException e) {
			throw new RuntimeException(e);  
		}
	}
	
	@StartElement(tag="convention")
	public void startAnnotationConfig(@Attribute("annotation") String annotationClass) {
		try {
			Class<?> anotClass = Class.forName(annotationClass);
			if(!Annotation.class.isAssignableFrom(anotClass)){
				throw new RuntimeException("The class "+annotationClass+ " is not an annotation");
			}else{
				currentClass = anotClass;
				if(!processors.containsKey(anotClass)){
					processors.put(anotClass, new ArrayList<ConventionProcessor>());
				}
			}
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("The class "+annotationClass+ " is not an annotation");
		}
	}
	
	@BeforeElement(elementDeep=1,tag="convention")
	@StartElement
	public void processorConfig(@Tag String tagName, @AttributeMap Map<String,String> map) {
		try {
			Class<? extends ConventionProcessor> processorClass = processorMap.get(tagName);
			ConventionProcessor processor = processorClass.newInstance();
			processor.initXML(map);
			processors.get(currentClass).add(processor);
		} catch (InstantiationException | IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}
	
	@EndElement(tag="convention")
	public void endAnnotationConfig() {
		currentClass = null;
	}
	

}
