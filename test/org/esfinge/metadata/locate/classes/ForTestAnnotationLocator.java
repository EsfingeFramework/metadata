package org.esfinge.metadata.locate.classes;

import org.esfinge.metadata.locate.annotations.FindMeAttributeLevel1;
import org.esfinge.metadata.locate.annotations.Administration;
import org.esfinge.metadata.locate.annotations.FindMeMethodLevel1;
import org.esfinge.metadata.locate.annotations.Logging;
import org.esfinge.metadata.locate.annotations.Transaction;

public class ForTestAnnotationLocator {
	@FindMeAttributeLevel1
	public String attribute;
	public int value;
	
	@FindMeMethodLevel1
	public void registerPurchase() {

	}
	
	@Logging @Transaction
	public void changeAdress(){
		
	}
	
	public void cancelPurchase(){
		
	}
	
	@Administration
	public void blockUser(){
		
	}
	
}
