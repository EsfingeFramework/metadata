package org.esfinge.metadata.validate.field.test;

import org.esfinge.metadata.annotation.container.field.OneAnnotationWithFieldVisibilityRequired;

public class PersonWithErrorFieldVisibilityRequired extends Person{
	
	@OneAnnotationWithFieldVisibilityRequired
	protected String oneProtectedString;	

	@OneAnnotationWithFieldVisibilityRequired
	transient String oneDefaultString;
	
	public PersonWithErrorFieldVisibilityRequired(String name, String cpf, int age) {
		super(name, cpf, age);
	}
	
}
