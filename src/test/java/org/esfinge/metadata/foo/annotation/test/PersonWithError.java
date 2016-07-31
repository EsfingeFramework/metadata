package org.esfinge.metadata.foo.annotation.test;

import org.esfinge.metadata.foo.annotation.InstanceFieldOnly;
import org.esfinge.metadata.foo.annotation.StaticFieldOnly;

public class PersonWithError extends Person{
		
	@StaticFieldOnly
	private String notStaticValue = "";
	
	@StaticFieldOnly
	protected String one_protected;
	
	@StaticFieldOnly
	String one_default;
	
	@InstanceFieldOnly
	private static String one_static_string = "";
	
	@InstanceFieldOnly
	private static String other_static_string = "";
	
	public PersonWithError(String name, String cpf, int age) {
		super(name, cpf, age);
	}
	
}
