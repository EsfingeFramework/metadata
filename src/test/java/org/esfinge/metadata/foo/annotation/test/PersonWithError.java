package org.esfinge.metadata.foo.annotation.test;

import org.esfinge.metadata.foo.annotation.FinalFieldOnly;
import org.esfinge.metadata.foo.annotation.InstanceFieldOnly;
import org.esfinge.metadata.foo.annotation.StaticFieldOnly;
import org.esfinge.metadata.foo.annotation.TransientFieldOnly;
import org.esfinge.metadata.foo.annotation.VolatileFieldOnly;

public class PersonWithError extends Person{
	
	@VolatileFieldOnly
	@StaticFieldOnly
	private String notStaticValue = "";
	
	@TransientFieldOnly
	@StaticFieldOnly
	protected String oneProtectedString;
	
	@TransientFieldOnly
	@FinalFieldOnly
	String oneFinalString;
	
	@FinalFieldOnly
	@InstanceFieldOnly
	private static String oneStaticString = "";
	
	@VolatileFieldOnly
	@InstanceFieldOnly
	private static String otherStaticString = "";
	
	public PersonWithError(String name, String cpf, int age) {
		super(name, cpf, age);
	}
	
}
