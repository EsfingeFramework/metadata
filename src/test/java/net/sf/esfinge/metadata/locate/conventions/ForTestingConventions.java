package net.sf.esfinge.metadata.locate.conventions;

public class ForTestingConventions {
	
	public Number field1;
	public Integer field2;
	public String field3;
	
	public void prefixMethod() {}
	
	public void methodSuffix() {
		
	}
	
	public void methodContainsRegex() {
		
	}
	
	public void regexAnywhereInMehod() {
		
	}
	
	@ForTesting
	public void withAnnotationMethod() {}
	
	public void noConventionMethod() {}

}
