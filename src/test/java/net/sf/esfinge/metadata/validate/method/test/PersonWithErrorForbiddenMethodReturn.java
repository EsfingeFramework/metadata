package net.sf.esfinge.metadata.validate.method.test;

import net.sf.esfinge.metadata.annotation.validator.method.OneAnnotationWithForbiddenMethodReturn;

public class PersonWithErrorForbiddenMethodReturn extends Person{
	
	float oneDefaultfloat = 4.2f;	

	transient static String oneDefaultString;
	
	public PersonWithErrorForbiddenMethodReturn(String name, String cpf, int age) {
		super(name, cpf, age);
	}

	@OneAnnotationWithForbiddenMethodReturn
	public float getOneDefaultfloat() {
		return oneDefaultfloat;
	}

	@OneAnnotationWithForbiddenMethodReturn
	public void setOneDefaultString(String oneDefaultString) {
		this.oneDefaultString = oneDefaultString;
	}
	
}
