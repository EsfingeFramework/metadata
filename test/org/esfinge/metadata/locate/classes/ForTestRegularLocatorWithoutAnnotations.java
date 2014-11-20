package org.esfinge.metadata.locate.classes;

import org.esfinge.metadata.locate.annotations.FindMeAttribute;
import org.esfinge.metadata.locate.annotations.FindMeClass;
import org.esfinge.metadata.locate.annotations.FindMeMethod;

public class ForTestRegularLocatorWithoutAnnotations {

	@FindMeMethod
	public String attribute;

	@FindMeClass
	@FindMeAttribute
	public void method() {

	}

}
