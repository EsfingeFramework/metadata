package net.sf.esfinge.metadata.locate.convention.processor;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Member;
import java.util.Map;

import net.sf.esfinge.metadata.locate.convention.ConventionProcessor;
import net.sf.esfinge.metadata.locate.convention.ConventionXMLTag;

@ConventionXMLTag("endswith")
public class PosfixConventionProcessor implements ConventionProcessor{
	
	private String name;

	public String getName() {
		return name;
	}

	@Override
	public boolean matchConvention(AnnotatedElement reflectionElement) {
		if (getName(reflectionElement).matches(".*(?i)"+name+"$")) return true;
		else return false;
	}

	@Override
	public void init(Annotation an) {
		ConventionNameEndsWith cne = (ConventionNameEndsWith) an;
		name = cne.posfix();
	}
	
	public static String getName(AnnotatedElement ae){
		if(ae instanceof Class){
			return ((Class) ae).getName();
		}else if(ae instanceof Member){
			return ((Member) ae).getName();
		}
		throw new RuntimeException("AnnotatedElement type is "+ ae.getClass());
	}

	@Override
	public void initXML(Map<String, String> attributeMap) {
		name = attributeMap.get("posfix");
	}

}
