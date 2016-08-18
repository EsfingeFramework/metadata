package org.esfinge.metadata.validate.field.test;

import java.util.HashSet;
import java.util.Set;

import org.esfinge.metadata.annotation.container.field.OneAnnotationWithFieldVisibilityForbidden;
import org.esfinge.metadata.annotation.container.field.OneAnnotationWithFieldVisibilityRequired;
import org.esfinge.metadata.annotation.container.field.OneAnnotationWithFinalFieldOnly;
import org.esfinge.metadata.annotation.container.field.OneAnnotationWithInstanceFieldOnly;
import org.esfinge.metadata.annotation.container.field.OneAnnotationWithStaticFieldOnly;
import org.esfinge.metadata.annotation.container.field.OneAnnotationWithTransientFieldOnly;
import org.esfinge.metadata.annotation.container.field.OneAnnotationWithValidFieldTypes;
import org.esfinge.metadata.annotation.container.field.OneAnnotationWithVolatileFieldOnly;

public class PersonWithError extends Person{
	
	@OneAnnotationWithStaticFieldOnly
	private int notStaticValue = 42;	
	
	@OneAnnotationWithFieldVisibilityRequired
	@OneAnnotationWithTransientFieldOnly
	protected String oneProtectedString;	
	
	@OneAnnotationWithValidFieldTypes
	@OneAnnotationWithTransientFieldOnly
	@OneAnnotationWithFinalFieldOnly
	float oneDefaultfloat = 4.2f;	

	@OneAnnotationWithFieldVisibilityRequired
	@OneAnnotationWithVolatileFieldOnly
	transient String oneDefaultString;

	@OneAnnotationWithValidFieldTypes
	@OneAnnotationWithFieldVisibilityForbidden
	@OneAnnotationWithFinalFieldOnly
	public volatile long oneVolatileLong = 2372983;	

	@OneAnnotationWithInstanceFieldOnly
	@OneAnnotationWithVolatileFieldOnly
	private static String oneStaticString = "";
	
	@OneAnnotationWithFieldVisibilityForbidden
	@OneAnnotationWithInstanceFieldOnly
	public static String otherStaticString = "";
	
	@OneAnnotationWithValidFieldTypes
	Set<Object> oneSet = new HashSet<>();	
	
	public PersonWithError(String name, String cpf, int age) {
		super(name, cpf, age);
	}
	
}
