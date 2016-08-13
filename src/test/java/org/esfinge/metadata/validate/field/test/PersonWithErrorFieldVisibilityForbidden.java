package org.esfinge.metadata.validate.field.test;

import org.esfinge.metadata.annotation.container.field.OneAnnotationWithFieldVisibilityForbidden;

public class PersonWithErrorFieldVisibilityForbidden extends Person{
		
	@OneAnnotationWithFieldVisibilityForbidden	
	public volatile long oneVolatileLong = 2372983;	

	@OneAnnotationWithFieldVisibilityForbidden	
	public static String otherStaticString = "";	
	
	public PersonWithErrorFieldVisibilityForbidden(String name, String cpf, int age) {
		super(name, cpf, age);
	}
	
}
