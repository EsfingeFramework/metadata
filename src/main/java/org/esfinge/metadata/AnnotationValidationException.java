package org.esfinge.metadata;

public class AnnotationValidationException extends Exception {
	
	public AnnotationValidationException(String message){
		super("\n****Esfinge Metadata Exception**** \n -> "+message);
		}
}
