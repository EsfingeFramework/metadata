package net.sf.esfinge.metadata.locate.convention;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.util.List;

import net.sf.esfinge.metadata.locate.MetadataLocator;
import net.sf.esfinge.metadata.locate.RegularLocator;
import net.sf.esfinge.metadata.locate.convention.finder.AnnotationBasedConventionFinder;
import net.sf.esfinge.metadata.locate.convention.finder.XMLBasedConventionFinder;

public class ConventionLocator {
	
	protected ConventionLocator nextConvention;
	protected MetadataLocator nextLocator;

	public void setNextConvention(ConventionLocator convention) {
		this.nextConvention = convention;
	}
	
	public void setNextLocator(MetadataLocator location) {
		this.nextLocator = location;
	}
	
	public boolean findMetadata(AnnotatedElement element,
			Class<? extends Annotation> annotationClass) {
		Annotation a = null;
		setNextLocator(new RegularLocator());
		a = nextLocator.findMetadata(element, annotationClass);
		if (a != null){
			return true;
		}
		else if (element instanceof Class){
			return false;
		} else
			try {
				return hasMetadata(element, annotationClass);
			} catch (IllegalAccessException | InstantiationException e) {
				e.printStackTrace();
				return false;
			}
	}

	public boolean hasMetadata(AnnotatedElement element, Class<? extends Annotation> annotation) throws InstantiationException, IllegalAccessException {
		if(element.isAnnotationPresent(annotation)){
			return true;
		}
		else {
			AnnotationBasedConventionFinder finder = new AnnotationBasedConventionFinder();
			List<ConventionProcessor> processors = finder.findConventions(annotation);
			for(ConventionProcessor processor: processors){
				if(processor.matchConvention(element)) 
					return true;
			XMLBasedConventionFinder finderXML = new XMLBasedConventionFinder();
			List<ConventionProcessor> XMLProcessors = finderXML.findConventions(annotation);
			for(ConventionProcessor XMLProcessor: XMLProcessors){
				if(XMLProcessor.matchConvention(element)) 
					return true;
				}
			}
		}
		return false;
	}
}
