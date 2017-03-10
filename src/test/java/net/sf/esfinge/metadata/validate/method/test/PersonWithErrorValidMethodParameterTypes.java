package net.sf.esfinge.metadata.validate.method.test;

public class PersonWithErrorValidMethodParameterTypes extends Person{	
	
	public PersonWithErrorValidMethodParameterTypes(String name, String cpf, int age) {
		super(name, cpf, age);
	}
	
	@OneAnnotationWithValidMethodParameterTypes
	public String someMethodStrIntError(String a, long b){
		return a + b;	
	}
	
	@OneAnnotationWithValidMethodParameterTypes
	public String otherMethodStrIntError(String a, int b, int c){
		return a + b + c;	
	}
	
	@OneAnnotationWithValidMethodParameterTypes
	public String otherMethodStrIntError(int a, String b){
		return a + b + "42";	
	}
	
	@OneAnnotationWithValidMethodParameterTypes
	public String otherMethodStrIntError(String a){
		return a;	
	}
	
}
