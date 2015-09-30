package org.esfinge.metadata.factory;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.esfinge.metadata.locate.AnnotationLocator;
import org.esfinge.metadata.locate.LevelLocator;
import org.esfinge.metadata.locate.MetadataLocator;
import org.esfinge.metadata.locate.RegularLocator;

public class LocatorsFactory {

	public MetadataLocator createLocatorsChain(AnnotatedElement element, Class<? extends Annotation> annotationClass) {
		MetadataLocator locator = null;

		if (element instanceof Method || element instanceof Class || element instanceof Field) {
			locator = new LevelLocator();
			locator.setNextLocator(new AnnotationLocator());
			locator.setNextLocator(new RegularLocator());
		}
		else if (element instanceof Annotation || element instanceof Package) {
			locator = new AnnotationLocator();
			locator.setNextLocator(new RegularLocator());
		}

		return locator;
	}
}