package org.esfinge.metadata.foo.annotation.visibility.test;

import java.util.HashSet;
import java.util.Set;

import org.esfinge.metadata.foo.annotation.OneAnnotationWithValidFieldTypes;
import org.esfinge.metadata.foo.annotation.test.Person;

public class PersonWithErrorValidFieldTypes extends Person{
	
	@OneAnnotationWithValidFieldTypes
	float oneDefaultfloat = 4.2f;	

	@OneAnnotationWithValidFieldTypes
	public volatile long oneVolatileLong = 2372983;	
	
	@OneAnnotationWithValidFieldTypes
	Set<Object> oneSet = new HashSet<>();	
	
	public PersonWithErrorValidFieldTypes(String name, String cpf, int age) {
		super(name, cpf, age);
	}
	
}
