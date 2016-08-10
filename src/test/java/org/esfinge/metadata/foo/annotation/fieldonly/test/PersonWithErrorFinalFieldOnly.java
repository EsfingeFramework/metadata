package org.esfinge.metadata.foo.annotation.fieldonly.test;

import org.esfinge.metadata.foo.annotation.OneAnnotationWithFinalFieldOnly;
import org.esfinge.metadata.foo.annotation.test.Person;

public class PersonWithErrorFinalFieldOnly extends Person{

	@OneAnnotationWithFinalFieldOnly
	float oneDefaultfloat = 4.2f;	

	@OneAnnotationWithFinalFieldOnly
	public volatile long oneVolatileLong = 2372983;
	
	public PersonWithErrorFinalFieldOnly(String name, String cpf, int age) {
		super(name, cpf, age);
	}
	
}
