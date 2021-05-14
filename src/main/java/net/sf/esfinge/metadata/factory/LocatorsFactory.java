package net.sf.esfinge.metadata.factory;

import java.lang.annotation.Annotation;

import net.sf.esfinge.metadata.AnnotationReadingException;
import net.sf.esfinge.metadata.annotation.finder.Locator;
import net.sf.esfinge.metadata.annotation.finder.SearchOnEnclosingElements;
import net.sf.esfinge.metadata.locate.EnclosingElementLocator;
import net.sf.esfinge.metadata.locate.MetadataLocator;
import net.sf.esfinge.metadata.locate.RegularLocator;
import net.sf.esfinge.metadata.locate.conventions.ConventionsLocator;

public class LocatorsFactory {

	public static MetadataLocator createLocatorsChain(Class<? extends Annotation> annotType) throws AnnotationReadingException {
		
		MetadataLocator locator = new ConventionsLocator();
		
		for(Annotation an : annotType.getAnnotations()) {
			if(an.annotationType().isAnnotationPresent(Locator.class)) {
				Locator l = an.annotationType().getAnnotation(Locator.class);
				MetadataLocator newLocator;
				Class<? extends MetadataLocator> metadataLocatorClass = l.value();
				try {
					newLocator = metadataLocatorClass.getConstructor().newInstance();
				} catch (Exception e) {
					throw new AnnotationReadingException("Problems instatiating locator "+metadataLocatorClass, e);
				}
				locator.setNextLocator(newLocator);
			}
			
		}
		
		locator.setNextLocator(new RegularLocator());
		return locator;
	}
}