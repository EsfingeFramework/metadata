package net.sf.esfinge.metadata.validate.field.test;

import java.util.HashSet;
import java.util.Set;

public class PersonWithErrorStaticFieldOnly extends Person{
	
	@OneAnnotationWithStaticFieldOnly
	private int notStaticValue = 42;	
	
	@OneAnnotationWithStaticFieldOnly
	Set<Object> oneSet = new HashSet<>();	
	
	public PersonWithErrorStaticFieldOnly(String name, String cpf, int age) {
		super(name, cpf, age);
	}
	
}
