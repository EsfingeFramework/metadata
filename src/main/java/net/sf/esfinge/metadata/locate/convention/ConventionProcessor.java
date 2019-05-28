package net.sf.esfinge.metadata.locate.convention;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.util.Map;

public interface ConventionProcessor {
	
	public boolean matchConvention(AnnotatedElement reflectionElement);
	
	public void init(Annotation an);
	
	public void initXML(Map<String,String> attributeMap);

}
