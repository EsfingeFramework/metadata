package org.esfinge.metadata.validate.field.test;

import org.esfinge.metadata.annotation.container.field.OneAnnotationWithInstanceFieldOnly;

public class PersonWithErrorInstanceFieldOnly extends Person{

	@OneAnnotationWithInstanceFieldOnly
	private static String oneStaticString = "";
	
	@OneAnnotationWithInstanceFieldOnly
	public static String otherStaticString = "";
	
	public PersonWithErrorInstanceFieldOnly(String name, String cpf, int age) {
		super(name, cpf, age);
	}
	
}
