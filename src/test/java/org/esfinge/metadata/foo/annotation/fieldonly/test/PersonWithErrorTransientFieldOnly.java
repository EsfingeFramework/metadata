package org.esfinge.metadata.foo.annotation.fieldonly.test;

import org.esfinge.metadata.foo.annotation.OneAnnotationWithTransientFieldOnly;
import org.esfinge.metadata.foo.annotation.test.Person;

public class PersonWithErrorTransientFieldOnly extends Person{
	
	@OneAnnotationWithTransientFieldOnly
	protected String oneProtectedString;	
	
	@OneAnnotationWithTransientFieldOnly
	float oneDefaultfloat = 4.2f;
	
	public PersonWithErrorTransientFieldOnly(String name, String cpf, int age) {
		super(name, cpf, age);
	}
	
}
