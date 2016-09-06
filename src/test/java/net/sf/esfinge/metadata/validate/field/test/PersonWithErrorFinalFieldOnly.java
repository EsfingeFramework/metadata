package net.sf.esfinge.metadata.validate.field.test;

import net.sf.esfinge.metadata.annotation.validator.field.OneAnnotationWithFinalFieldOnly;

public class PersonWithErrorFinalFieldOnly extends Person{

	@OneAnnotationWithFinalFieldOnly
	float oneDefaultfloat = 4.2f;	

	@OneAnnotationWithFinalFieldOnly
	public volatile long oneVolatileLong = 2372983;
	
	public PersonWithErrorFinalFieldOnly(String name, String cpf, int age) {
		super(name, cpf, age);
	}
	
}
