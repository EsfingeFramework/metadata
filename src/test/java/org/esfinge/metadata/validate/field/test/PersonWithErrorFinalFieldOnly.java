package org.esfinge.metadata.validate.field.test;

import org.esfinge.metadata.annotation.container.field.OneAnnotationWithFinalFieldOnly;

public class PersonWithErrorFinalFieldOnly extends Person{

	@OneAnnotationWithFinalFieldOnly
	float oneDefaultfloat = 4.2f;	

	@OneAnnotationWithFinalFieldOnly
	public volatile long oneVolatileLong = 2372983;
	
	public PersonWithErrorFinalFieldOnly(String name, String cpf, int age) {
		super(name, cpf, age);
	}
	
}
