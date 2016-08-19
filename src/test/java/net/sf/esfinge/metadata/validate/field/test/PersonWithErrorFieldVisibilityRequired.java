package net.sf.esfinge.metadata.validate.field.test;

import net.sf.esfinge.metadata.annotation.container.field.OneAnnotationWithFieldVisibilityRequired;

public class PersonWithErrorFieldVisibilityRequired extends Person{
	
	@OneAnnotationWithFieldVisibilityRequired
	protected String oneProtectedString;	

	@OneAnnotationWithFieldVisibilityRequired
	transient String oneDefaultString;
	
	public PersonWithErrorFieldVisibilityRequired(String name, String cpf, int age) {
		super(name, cpf, age);
	}
	
}
