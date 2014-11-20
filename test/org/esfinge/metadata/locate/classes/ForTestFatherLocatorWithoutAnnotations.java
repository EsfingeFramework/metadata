package org.esfinge.metadata.locate.classes;

import org.esfinge.metadata.locate.annotations.FindMeAttribute;
import org.esfinge.metadata.locate.annotations.FindMeClass;

public class ForTestFatherLocatorWithoutAnnotations {
	
	@FindMeAttribute
	public String attribute;

	@FindMeClass
	public void method() {

	}
}
