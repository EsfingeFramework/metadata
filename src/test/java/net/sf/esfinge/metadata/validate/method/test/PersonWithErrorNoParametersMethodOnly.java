package net.sf.esfinge.metadata.validate.method.test;

public class PersonWithErrorNoParametersMethodOnly extends Person{
	
	protected String oneProtectedString;	

	public volatile long oneVolatileLong = 2372983;		
	
	
	public PersonWithErrorNoParametersMethodOnly(String name, String cpf, int age) {
		super(name, cpf, age);
	}
	
	@OneAnnotationWithNoParametersMethodOnly
	public void setOneProtectedString(String oneProtectedString) {
		this.oneProtectedString = oneProtectedString;
	}

	@OneAnnotationWithNoParametersMethodOnly
	private strictfp void setOneVolatileLong(long oneVolatileLong) {
		this.oneVolatileLong = oneVolatileLong;
	}
	
}
