package org.esfinge.metadata.locate.levelLocator;

import org.esfinge.metadata.locate.annotations.Transaction;
import org.esfinge.metadata.locate.annotations.FindMeMethod;
import org.esfinge.metadata.locate.annotations.FindMePackage;

//@FindMePackage
@Transaction
public class ForTestLevelLocator {		
		//@FindMeMethod
		//@FindMePackage
		public String attribute;

		// se o acesso for privado ou protegido, o metodo n encontra a anotacao
		//@FindMePackage
		public void method() {

		}
	}
