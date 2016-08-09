package org.esfinge.metadata.foo.annotation.fieldonly.test;

import org.esfinge.metadata.foo.annotation.OneAnnotationWithVolatileFieldOnly;
import org.esfinge.metadata.foo.annotation.test.Person;

public class PersonWithErrorVolatileFieldOnly extends Person{
	
	@OneAnnotationWithVolatileFieldOnly
	transient String oneDefaultString;

	@OneAnnotationWithVolatileFieldOnly
	private static String oneStaticString = "";	
	
	public PersonWithErrorVolatileFieldOnly(String name, String cpf, int age) {
		super(name, cpf, age);
	}
	
}
