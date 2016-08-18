package org.esfinge.metadata.validate.field.test;

import org.esfinge.metadata.annotation.container.field.OneAnnotationWithVolatileFieldOnly;

public class PersonWithErrorVolatileFieldOnly extends Person{
	
	@OneAnnotationWithVolatileFieldOnly
	transient String oneDefaultString;

	@OneAnnotationWithVolatileFieldOnly
	private static String oneStaticString = "";	
	
	public PersonWithErrorVolatileFieldOnly(String name, String cpf, int age) {
		super(name, cpf, age);
	}
	
}
