package net.sf.esfinge.metadata.locate.conventions;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;

import net.sf.esfinge.metadata.locate.MetadataLocationException;
import net.sf.esfinge.metadata.locate.MetadataLocator;

public class ConventionsLocator extends MetadataLocator {

	@Override
	public Annotation findMetadata(AnnotatedElement element, Class<? extends Annotation> annotationClass)
			throws MetadataLocationException {
		return nextLocator.findMetadata(element, annotationClass);
	}

	@Override
	public boolean hasMetadata(AnnotatedElement element, Class<? extends Annotation> annotationClass) {
		// TODO Auto-generated method stub
		return nextLocator.hasMetadata(element, annotationClass);
		
		//if false
		//see if the annotation has a prefix annotation
		//get the prefix value if available
		//if the element has the prefix, return true
	}

}
