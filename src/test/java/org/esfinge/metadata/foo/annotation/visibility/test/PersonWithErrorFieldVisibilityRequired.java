package org.esfinge.metadata.foo.annotation.visibility.test;

import org.esfinge.metadata.foo.annotation.OneAnnotationWithFieldVisibilityRequired;
import org.esfinge.metadata.foo.annotation.test.Person;

public class PersonWithErrorFieldVisibilityRequired extends Person{
	
	@OneAnnotationWithFieldVisibilityRequired
	protected String oneProtectedString;	

	@OneAnnotationWithFieldVisibilityRequired
	transient String oneDefaultString;
	
	public PersonWithErrorFieldVisibilityRequired(String name, String cpf, int age) {
		super(name, cpf, age);
	}
	
}
