package net.sf.esfinge.metadata.locate.convention.finder;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

import net.sf.esfinge.metadata.locate.convention.ConventionAnnotation;
import net.sf.esfinge.metadata.locate.convention.ConventionFinder;
import net.sf.esfinge.metadata.locate.convention.ConventionProcessor;

public class AnnotationBasedConventionFinder implements ConventionFinder {

	@Override
	public List<ConventionProcessor> findConventions(Class<? extends Annotation> annotation) {
		try {
			List<ConventionProcessor> processors = new ArrayList<>();
			for(Annotation an: annotation.getAnnotations()){
				if(an.annotationType().isAnnotationPresent(ConventionAnnotation.class)){
					ConventionAnnotation conAnn = an.annotationType().getAnnotation(ConventionAnnotation.class);
					Class<? extends ConventionProcessor> processorClass = conAnn.value();
					ConventionProcessor processor = processorClass.newInstance();
					processor.init(an);
					processors.add(processor);
				}
			}
			return processors;
		} catch (InstantiationException|IllegalAccessException e) {
			throw new RuntimeException(e);
		} 
	}

}
