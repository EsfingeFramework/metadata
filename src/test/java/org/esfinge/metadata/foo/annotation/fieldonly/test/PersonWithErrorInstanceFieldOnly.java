package org.esfinge.metadata.foo.annotation.fieldonly.test;

import org.esfinge.metadata.foo.annotation.OneAnnotationWithInstanceFieldOnly;
import org.esfinge.metadata.foo.annotation.test.Person;

public class PersonWithErrorInstanceFieldOnly extends Person{

	@OneAnnotationWithInstanceFieldOnly
	private static String oneStaticString = "";
	
	@OneAnnotationWithInstanceFieldOnly
	public static String otherStaticString = "";
	
	public PersonWithErrorInstanceFieldOnly(String name, String cpf, int age) {
		super(name, cpf, age);
	}
	
}
