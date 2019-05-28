package net.sf.esfinge.metadata.locate.convention.finder;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import net.sf.esfinge.metadata.locate.convention.ConventionAnnotation;
import net.sf.esfinge.metadata.locate.convention.ConventionFinder;
import net.sf.esfinge.metadata.locate.convention.ConventionProcessor;
import net.sf.esfinge.metadata.locate.convention.ConventionXMLTag;
import net.sf.jColtrane.annotations.args.AttributeMap;
import net.sf.jColtrane.annotations.args.CurrentBranch;
import net.sf.jColtrane.annotations.args.Tag;
import net.sf.jColtrane.annotations.methods.StartElement;
import net.sf.jColtrane.handler.JColtraneXMLHandler;

public class XMLBasedConventionFinder implements ConventionFinder {
	
	private static Map<Class<? extends Annotation>,List<ConventionProcessor>> xmlDefinedProcessors = new HashMap<>();
		
	public static void loadAnnotationConventions(File path){
		
	}
	
	public static void clearConventions(){
		xmlDefinedProcessors.clear();
	}
	
	@Override
	public List<ConventionProcessor> findConventions(Class<? extends Annotation> annotation) {
		try {
			List<ConventionProcessor> processors = new ArrayList<>();
			for(Annotation an: annotation.getAnnotations()){
				if(an.annotationType().isAnnotationPresent(ConventionAnnotation.class)){
					ConventionAnnotation conAnn = an.annotationType().getAnnotation(ConventionAnnotation.class);
					Class<? extends ConventionProcessor> processorClass = conAnn.value();
					ConventionProcessor processor = processorClass.newInstance();
					processors.add(processor);
				}
			}
			return processors;
		} catch (InstantiationException|IllegalAccessException e) {
			throw new RuntimeException(e);
		} 
	}

}
