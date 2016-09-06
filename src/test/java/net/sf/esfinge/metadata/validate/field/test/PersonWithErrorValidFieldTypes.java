package net.sf.esfinge.metadata.validate.field.test;

import java.util.HashSet;
import java.util.Set;

import net.sf.esfinge.metadata.annotation.validator.field.OneAnnotationWithValidFieldTypes;

public class PersonWithErrorValidFieldTypes extends Person{
	
	@OneAnnotationWithValidFieldTypes
	float oneDefaultfloat = 4.2f;	

	@OneAnnotationWithValidFieldTypes
	public volatile long oneVolatileLong = 2372983;	
	
	@OneAnnotationWithValidFieldTypes
	Set<Object> oneSet = new HashSet<>();	
	
	public PersonWithErrorValidFieldTypes(String name, String cpf, int age) {
		super(name, cpf, age);
	}
	
}
