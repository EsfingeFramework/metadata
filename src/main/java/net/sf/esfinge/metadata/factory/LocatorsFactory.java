package net.sf.esfinge.metadata.factory;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import net.sf.esfinge.metadata.locate.EnclosingElementLocator;
import net.sf.esfinge.metadata.locate.InsideAnnotationLocator;
import net.sf.esfinge.metadata.locate.MetadataLocator;
import net.sf.esfinge.metadata.locate.RegularLocator;

public class LocatorsFactory {
	private MetadataLocator locator = null;

	public MetadataLocator createLocatorsChain(AnnotatedElement element) {
		
		if (element instanceof Method 
				|| element instanceof Class
				|| element instanceof Field) {
			locator = new EnclosingElementLocator();
			locator.setNextLocator(new InsideAnnotationLocator());
			locator.setNextLocator(new RegularLocator());
		} else if (element instanceof Annotation 
				|| element instanceof Package) {
			locator = new InsideAnnotationLocator();
			locator.setNextLocator(new RegularLocator());
		}
		 
		
		
		return locator;
	}
}