package net.sf.esfinge.metadata.locate.conventions;

import java.lang.reflect.AnnotatedElement;

import net.sf.esfinge.metadata.locate.conventions.annotations.PrefixConvention;
import net.sf.esfinge.metadata.utils.AnnotatedElementUtils;

public class PrefixConventionVerifier implements ConventionVerifier<PrefixConvention>{
	
	private String prefix;

	@Override
	public void init(PrefixConvention conventionAnnotation) {
		prefix =conventionAnnotation.value();
	}

	@Override
	public boolean isConventionPresent(AnnotatedElement element) {
		String name = AnnotatedElementUtils.getName(element);
		return name.startsWith(prefix);
	}

}
