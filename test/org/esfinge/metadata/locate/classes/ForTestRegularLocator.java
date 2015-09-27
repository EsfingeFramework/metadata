package org.esfinge.metadata.locate.classes;

import org.esfinge.metadata.locate.annotations.FindMeAttribute;
import org.esfinge.metadata.locate.annotations.Transaction;
import org.esfinge.metadata.locate.annotations.FindMeMethod;

@Transaction
public class ForTestRegularLocator {

	@FindMeAttribute
	public String attribute;

	// se o acesso for privado ou protegido, o metodo n encontra a anotacao

	@FindMeMethod
	public void method() {

	}
}
