package net.sf.esfinge.metadata.validate.method.test;

public class PersonWithErrorValidMethodReturn extends Person{
	
	public volatile long oneVolatileLong = 2372983;	
	
	public static String otherStaticString = "";
	
	public PersonWithErrorValidMethodReturn(String name, String cpf, int age) {
		super(name, cpf, age);
	}

	
	@OneAnnotationWithValidMethodReturn
	private long getOneVolatileLong() {
		return oneVolatileLong;
	}

	@OneAnnotationWithValidMethodReturn
	public static void setOtherStaticString(String otherStaticString) {
		PersonWithErrorValidMethodReturn.otherStaticString = otherStaticString;
	}	
}
