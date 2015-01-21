package org.esfinge.metadata.locate.classes;

import org.esfinge.metadata.locate.annotations.FindMeAttributeLevel1;
import org.esfinge.metadata.locate.annotations.FindMeClassLevel1;
import org.esfinge.metadata.locate.annotations.FindMeMethodLevel1;
import org.esfinge.metadata.locate.annotations.FindMeMethodLevel2;

@FindMeClassLevel1
public class ForTestAnnotationLocator {
	@FindMeAttributeLevel1
	public String attribute;

	@FindMeMethodLevel1
	public void method() {

	}
	
	@FindMeMethodLevel2
	public void method2(){
		
	}
}
