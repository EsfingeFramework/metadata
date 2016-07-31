package org.esfinge.metadata.foo.annotation.test;

import org.esfinge.metadata.foo.annotation.FinalFieldOnly;
import org.esfinge.metadata.foo.annotation.InstanceFieldOnly;
import org.esfinge.metadata.foo.annotation.StaticFieldOnly;

public class PersonWithError extends Person{
		
	@StaticFieldOnly
	private String notStaticValue = "";
	
	@StaticFieldOnly
	protected String oneProtectedString;
	
	@FinalFieldOnly
	String oneFinalString;
	
	@InstanceFieldOnly
	private static String oneStaticString = "";
	
	@InstanceFieldOnly
	private static String otherStaticString = "";
	
	public PersonWithError(String name, String cpf, int age) {
		super(name, cpf, age);
	}
	
}
