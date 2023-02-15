package net.sf.esfinge.metadata.locate.conventions;

import java.lang.reflect.AnnotatedElement;
import java.util.Map;

import net.sf.esfinge.metadata.locate.conventions.annotations.SuffixConvention;
import net.sf.esfinge.metadata.utils.AnnotatedElementUtils;

public class SuffixConventionVerifier implements ConventionVerifier<SuffixConvention>{
	
	private String suffix;

	@Override
	public void init(SuffixConvention conventionAnnotation) {
		suffix =conventionAnnotation.value();
		String firstLetStr = suffix.substring(0, 1); 
		String remLetStr = suffix.substring(1); 
		firstLetStr = firstLetStr.toUpperCase(); 
		suffix = firstLetStr + remLetStr;

	}
	@Override
	public void init(Map<String, String> parameters) {
		suffix = parameters.get("suffix");
		String firstLetStr = suffix.substring(0, 1);
		String remLetStr = suffix.substring(1);
		firstLetStr = firstLetStr.toUpperCase();
		suffix = firstLetStr + remLetStr;
	}
	@Override
	public boolean isConventionPresent(AnnotatedElement element) {
		String name = AnnotatedElementUtils.getName(element);
		return name.endsWith(suffix);
	}

}