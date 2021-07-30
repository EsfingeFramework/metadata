package net.sf.esfinge.metadata.locate.conventions;

import java.lang.reflect.AnnotatedElement;

import net.sf.esfinge.metadata.locate.conventions.annotations.RegularExpressionConvention;
import net.sf.esfinge.metadata.utils.AnnotatedElementUtils;

public class RegularExpressionConventionVerifier implements ConventionVerifier<RegularExpressionConvention>{

	
	private String regex;
	private String upperCaseRegex;
	
	@Override
	public void init(RegularExpressionConvention conventionAnnotation) {
		regex =conventionAnnotation.value();
		
		upperCaseRegex = regex;
		String firstLetStr = upperCaseRegex.substring(0, 1); 
		String remLetStr = upperCaseRegex.substring(1); 
		firstLetStr = firstLetStr.toUpperCase(); 
		upperCaseRegex = firstLetStr + remLetStr;
		
	}

	@Override
	public boolean isConventionPresent(AnnotatedElement element) {
		String name = AnnotatedElementUtils.getName(element);
		
		if(name.matches(".*"+ regex +".*") || name.matches(".*"+ upperCaseRegex +".*")) {
			return true;
		}
		
		return false;
	}

}
