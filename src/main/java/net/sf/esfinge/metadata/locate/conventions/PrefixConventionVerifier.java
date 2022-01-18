package net.sf.esfinge.metadata.locate.conventions;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;
import java.util.Map;

import net.sf.esfinge.metadata.locate.conventions.annotations.PrefixConvention;
import net.sf.esfinge.metadata.utils.AnnotatedElementUtils;

public class PrefixConventionVerifier implements ConventionVerifier<PrefixConvention>{
	
	private String prefix;

	@Override
	public void init(PrefixConvention conventionAnnotation) {
		prefix =conventionAnnotation.value();
	}

	@Override
	public void init(Map<String, String> parameters) {
		prefix = parameters.get("value");
	}

	@Override
	public boolean isConventionPresent(AnnotatedElement element) {

		String name = AnnotatedElementUtils.getName(element);
		return name.startsWith(prefix);
	}

}
