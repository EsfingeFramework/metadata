package net.sf.esfinge.metadata.locate.convention;

import java.lang.annotation.Annotation;
import java.util.List;

public interface ConventionFinder {
	
	public List<ConventionProcessor> findConventions(Class<? extends Annotation> an);

}
