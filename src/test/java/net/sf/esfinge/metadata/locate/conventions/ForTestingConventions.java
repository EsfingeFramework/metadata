package net.sf.esfinge.metadata.locate.conventions;

public class ForTestingConventions {
	
	public void prefixMethod() {}
	
	public void methodSuffix() {
		
	}
	
	@ForTesting
	public void withAnnotationMethod() {}
	
	public void noConventionMethod() {}

}
