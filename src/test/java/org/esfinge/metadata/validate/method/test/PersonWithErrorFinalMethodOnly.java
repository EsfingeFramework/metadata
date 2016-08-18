package org.esfinge.metadata.validate.method.test;

import org.esfinge.metadata.annotation.container.method.OneAnnotationWithFinalMethodOnly;

public class PersonWithErrorFinalMethodOnly extends Person{
	
	private int notStaticValue = 42;	
	
	protected String oneProtectedString;	
		
	
	public PersonWithErrorFinalMethodOnly(String name, String cpf, int age) {
		super(name, cpf, age);
	}

	@OneAnnotationWithFinalMethodOnly
	public int getNotStaticValue() {
		return notStaticValue;
	}
	
	@OneAnnotationWithFinalMethodOnly
	public void setNotStaticValue(int notStaticValue) {
		this.notStaticValue = notStaticValue;
	}	
}
