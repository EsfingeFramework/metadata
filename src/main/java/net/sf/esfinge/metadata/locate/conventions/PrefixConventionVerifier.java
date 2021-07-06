package net.sf.esfinge.metadata.locate.conventions;

import java.lang.reflect.AnnotatedElement;

import net.sf.esfinge.metadata.locate.conventions.annotations.PrefixConvention;

public class PrefixConventionVerifier implements ConventionVerifier<PrefixConvention>{

	@Override
	public void init(PrefixConvention conventionAnnotation) {
		//retrieve inforation you need from the annotation (in this case, what is prefix)
		
	}

	@Override
	public boolean isConventionPresent(AnnotatedElement element) {
		// verify the convention
		return false;
	}

}
