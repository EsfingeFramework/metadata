package net.sf.esfinge.metadata.factory;

import java.lang.annotation.Annotation;

import net.sf.esfinge.metadata.AnnotationReadingException;
import net.sf.esfinge.metadata.annotation.finder.Locator;
import net.sf.esfinge.metadata.annotation.finder.SearchOnEnclosingElements;
import net.sf.esfinge.metadata.locate.*;
import net.sf.esfinge.metadata.locate.conventions.ConventionsLocator;

public class LocatorsFactory {

//	public static MetadataLocator createLocatorsChain(Class<? extends Annotation> annotType) throws AnnotationReadingException {
//
//		MetadataLocator locator = new ConventionsLocator();
//		for(Annotation an : annotType.getAnnotations()) {
//			System.out.println(an.annotationType().getName()+" "+an.annotationType().isAnnotationPresent(Locator.class));
//			if(an.annotationType().isAnnotationPresent(Locator.class)) {
//
//				Locator l = an.annotationType().getAnnotation(Locator.class);
//				MetadataLocator newLocator;
//				Class<? extends MetadataLocator> metadataLocatorClass = l.value();
//				try {
//					newLocator = metadataLocatorClass.getConstructor().newInstance();
//				} catch (Exception e) {
//					throw new AnnotationReadingException("Problems instatiating locator "+metadataLocatorClass, e);
//				}
//				locator.setNextLocator(newLocator);
//			}
//
//		}
//
//		locator.setNextLocator(new RegularLocator());
//
//		return locator;
//	}
	@Deprecated
public static MetadataLocator createLocatorsChain(Class<? extends Annotation> annotType) throws AnnotationReadingException{
	return createLocatorsChain();
}
	public static MetadataLocator createLocatorsChain() throws AnnotationReadingException {

		MetadataLocator conventionsLocator = new ConventionsLocator();
		MetadataLocator insideAnnotationsLocator = new InsideAnnotationLocator();
		MetadataLocator enclosingElementsLocator = new EnclosingElementLocator();
		MetadataLocator abstractionsLocator = new InheritanceLocator();
		MetadataLocator regularLocator = new RegularLocator();
		conventionsLocator.setNextLocator(insideAnnotationsLocator);
		insideAnnotationsLocator.setNextLocator(enclosingElementsLocator);
		enclosingElementsLocator.setNextLocator(abstractionsLocator);
		abstractionsLocator.setNextLocator(regularLocator);
		return conventionsLocator;
	}
}