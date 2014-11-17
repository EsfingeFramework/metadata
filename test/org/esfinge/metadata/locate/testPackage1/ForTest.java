package org.esfinge.metadata.locate.testPackage1;

import org.esfinge.metadata.locate.FindMeAttribute;
import org.esfinge.metadata.locate.FindMeClass;
import org.esfinge.metadata.locate.FindMeMethod;

@FindMeClass
public class ForTest {

	@FindMeAttribute
	public String attribute;

	// se o acesso for privado ou protegido, o metodo n encontra a anotacao

	@FindMeMethod
	public void method() {

	}
}