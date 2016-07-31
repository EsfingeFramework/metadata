package org.esfinge.metadata.foo.annotation.test;

import org.esfinge.metadata.foo.annotation.StaticFieldOnly;

public class PersonWithError extends Person{
		
	@StaticFieldOnly
	private String notStaticValue = "";
	
	@StaticFieldOnly
	protected String one_protected;
	
	@StaticFieldOnly
	String one_default;
	
	public PersonWithError(String name, String cpf, int age) {
		super(name, cpf, age);
	}
	
}
