package org.esfinge.metadata.foo.annotation.test;

import java.util.HashSet;
import java.util.Set;

import org.esfinge.metadata.foo.annotation.OneAnnotationWithFieldVisibilityForbidden;
import org.esfinge.metadata.foo.annotation.OneAnnotationWithFieldVisibilityRequired;
import org.esfinge.metadata.foo.annotation.OneAnnotationWithFinalFieldOnly;
import org.esfinge.metadata.foo.annotation.OneAnnotationWithInstanceFieldOnly;
import org.esfinge.metadata.foo.annotation.OneAnnotationWithStaticFieldOnly;
import org.esfinge.metadata.foo.annotation.OneAnnotationWithTransientFieldOnly;
import org.esfinge.metadata.foo.annotation.OneAnnotationWithValidFieldTypes;
import org.esfinge.metadata.foo.annotation.OneAnnotationWithVolatileFieldOnly;

public class PersonWithError extends Person{
	
	@OneAnnotationWithValidFieldTypes
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
	Set oneSet = new HashSet<>();

	
	
	
//	
//	@FieldVisibilityForbidden(itCannotHaveThisVisibility = "protected")
//	@FieldVisibilityRequired(itNeedsToHaveThisVisibility = "default")
//	@TransientFieldOnly
//	protected String oneProtectedString;
//	
//	@FieldVisibilityForbidden(itCannotHaveThisVisibility = "default")
//	@ValidFieldTypes(listValidTypes = { List.class })
//	@TransientFieldOnly
//	@FinalFieldOnly
//	String oneDefaultString;
//	
//	@FieldVisibilityForbidden(itCannotHaveThisVisibility = "")
//	@VolatileFieldOnly
//	String otherDefaultString;
//	
//	@FieldVisibilityRequired(itNeedsToHaveThisVisibility = "protected")
//	@FinalFieldOnly
//	@InstanceFieldOnly
//	private static String oneStaticString = "";
//	
//	@FieldVisibilityRequired(itNeedsToHaveThisVisibility = "")
//	@ValidFieldTypes(listValidTypes = { int.class })
//	@VolatileFieldOnly
//	@InstanceFieldOnly
//	private static String otherStaticString = "";
	
	
	
	public PersonWithError(String name, String cpf, int age) {
		super(name, cpf, age);
	}
	
}
