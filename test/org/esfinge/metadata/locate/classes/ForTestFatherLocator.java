package org.esfinge.metadata.locate.classes;

import org.esfinge.metadata.locate.annotations.FindMeClass;
import org.esfinge.metadata.locate.annotations.FindMeMethod;
import org.esfinge.metadata.locate.annotations.FindMePackage;

@FindMePackage
public class ForTestFatherLocator {
		@FindMeClass
		@FindMeMethod
		@FindMePackage
		public String attribute;

		// se o acesso for privado ou protegido, o metodo n encontra a anotacao

		@FindMeClass
		@FindMePackage
		public void method() {

		}
	}
