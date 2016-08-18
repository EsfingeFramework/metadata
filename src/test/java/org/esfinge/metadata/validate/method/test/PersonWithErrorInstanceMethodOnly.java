package org.esfinge.metadata.validate.method.test;

import org.esfinge.metadata.annotation.container.method.OneAnnotationWithInstanceMethodOnly;

public class PersonWithErrorInstanceMethodOnly extends Person{
	
	private static String oneStaticString = "";	
	
	public PersonWithErrorInstanceMethodOnly(String name, String cpf, int age) {
		super(name, cpf, age);
	}

	@OneAnnotationWithInstanceMethodOnly
	public static String getOneStaticString() {
		return oneStaticString;
	}

	@OneAnnotationWithInstanceMethodOnly
	public static void setOneStaticString(String oneStaticString) {
		PersonWithErrorInstanceMethodOnly.oneStaticString = oneStaticString;
	}

}
