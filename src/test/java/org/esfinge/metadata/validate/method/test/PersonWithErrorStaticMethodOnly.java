package org.esfinge.metadata.validate.method.test;

import org.esfinge.metadata.annotation.container.method.OneAnnotationWithStaticMethodOnly;

public class PersonWithErrorStaticMethodOnly extends Person{
	
	protected String oneProtectedString;	
	
	float oneDefaultfloat = 4.2f;	
	
	public PersonWithErrorStaticMethodOnly(String name, String cpf, int age) {
		super(name, cpf, age);
	}

	@OneAnnotationWithStaticMethodOnly
	public void setOneProtectedString(String oneProtectedString) {
		this.oneProtectedString = oneProtectedString;
	}

	@OneAnnotationWithStaticMethodOnly
	public strictfp void setOneDefaultfloat(float oneDefaultfloat) {
		this.oneDefaultfloat = oneDefaultfloat;
	}

}
