package net.sf.esfinge.metadata.validate.field.test;

import net.sf.esfinge.metadata.annotation.container.field.OneAnnotationWithTransientFieldOnly;

public class PersonWithErrorTransientFieldOnly extends Person{
	
	@OneAnnotationWithTransientFieldOnly
	protected String oneProtectedString;	
	
	@OneAnnotationWithTransientFieldOnly
	float oneDefaultfloat = 4.2f;
	
	public PersonWithErrorTransientFieldOnly(String name, String cpf, int age) {
		super(name, cpf, age);
	}
	
}
