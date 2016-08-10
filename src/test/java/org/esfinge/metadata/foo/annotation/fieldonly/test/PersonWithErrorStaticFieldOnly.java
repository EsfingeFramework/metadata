package org.esfinge.metadata.foo.annotation.fieldonly.test;

import java.util.HashSet;
import java.util.Set;

import org.esfinge.metadata.foo.annotation.OneAnnotationWithStaticFieldOnly;
import org.esfinge.metadata.foo.annotation.test.Person;

public class PersonWithErrorStaticFieldOnly extends Person{
	
	@OneAnnotationWithStaticFieldOnly
	private int notStaticValue = 42;	
	
	@OneAnnotationWithStaticFieldOnly
	Set<Object> oneSet = new HashSet<>();	
	
	public PersonWithErrorStaticFieldOnly(String name, String cpf, int age) {
		super(name, cpf, age);
	}
	
}
