package net.sf.esfinge.metadata.locate.conventions;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.esfinge.metadata.locate.MetadataLocationException;
import net.sf.esfinge.metadata.locate.MetadataLocator;
import net.sf.esfinge.metadata.locate.conventions.annotations.AllConventionsNeedToApply;
import net.sf.esfinge.metadata.locate.conventions.annotations.Verifier;
import net.sf.esfinge.metadata.utils.AnnotatedElementUtils;

public class ConventionsLocator extends MetadataLocator {

	private static Map<Class<?>, ConventionsMetadataContainer> conventionsDefinitions = new HashMap<>();

	// the parameter can be inputstring etc...
	public static void loadConventions(String filename) {
		// get the conventions from the file
		// store them in a static variable
	}

	@Override
	public Annotation findMetadata(AnnotatedElement element, Class<? extends Annotation> annotationClass)
			throws MetadataLocationException {

		if (!nextLocator.hasMetadata(element, annotationClass) && isConventionsPresent(element, annotationClass)) {
			Annotation an = AnnotatedElementUtils.instantiateAnnotation(annotationClass);
			return an;
		}

		return nextLocator.findMetadata(element, annotationClass);
	}

	@Override
	public boolean hasMetadata(AnnotatedElement element, Class<? extends Annotation> annotationClass)
			throws MetadataLocationException {

		if (!nextLocator.hasMetadata(element, annotationClass)) {
			return isConventionsPresent(element, annotationClass);
		}

		return nextLocator.hasMetadata(element, annotationClass);
	}

	private boolean isConventionsPresent(AnnotatedElement element, Class<? extends Annotation> annotationClass) {

		ConventionsMetadataContainer cmc = getConventions(annotationClass);
		boolean result = cmc.isAllConventionsNeedToApply();

		for (ConventionVerifier convVer : cmc.getVerifiers()) {
			boolean hasConv = convVer.isConventionPresent(element);
			if (cmc.isAllConventionsNeedToApply())
				result = result && hasConv;
			else
				result = result || hasConv;
		}
		return result;
	}

	private ConventionsMetadataContainer getConventions(Class<? extends Annotation> annotationClass) {
		if (conventionsDefinitions.containsKey(annotationClass)) {
			return conventionsDefinitions.get(annotationClass);
		} else {
			ConventionsMetadataContainer cmc = new ConventionsMetadataContainer();
			cmc.setAllConventionsNeedToApply(annotationClass.isAnnotationPresent(AllConventionsNeedToApply.class));
			for (Annotation annot : annotationClass.getAnnotations()) {
				try {
					if (annot.annotationType().isAnnotationPresent(Verifier.class)) {
						Verifier v = annot.annotationType().getAnnotation(Verifier.class);
						Class<? extends ConventionVerifier> convClazz = v.value();
						ConventionVerifier convVer = convClazz.getConstructor().newInstance();
						convVer.init(annot);
						cmc.getVerifiers().add(convVer);
					}
				} catch (Exception e) {
					throw new MetadataLocationException(e);
				}
			}
			conventionsDefinitions.put(annotationClass, cmc);
			return cmc;
		}
	}

}
