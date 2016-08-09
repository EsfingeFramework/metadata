package org.esfinge.metadata.foo.annotation.visibility.test;

import org.esfinge.metadata.foo.annotation.OneAnnotationWithFieldVisibilityForbidden;
import org.esfinge.metadata.foo.annotation.test.Person;

public class PersonWithErrorFieldVisibilityForbidden extends Person{
		
	@OneAnnotationWithFieldVisibilityForbidden	
	public volatile long oneVolatileLong = 2372983;	

	@OneAnnotationWithFieldVisibilityForbidden	
	public static String otherStaticString = "";	
	
	public PersonWithErrorFieldVisibilityForbidden(String name, String cpf, int age) {
		super(name, cpf, age);
	}
	
}
