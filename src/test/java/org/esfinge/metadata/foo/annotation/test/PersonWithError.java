package org.esfinge.metadata.foo.annotation.test;

import org.esfinge.metadata.foo.annotation.OneAnnotationWithFinalFieldOnly;
import org.esfinge.metadata.foo.annotation.OneAnnotationWithStaticFieldOnly;
import org.esfinge.metadata.foo.annotation.OneAnnotationWithTransientFieldOnly;
import org.esfinge.metadata.foo.annotation.OneAnnotationWithVolatileFieldOnly;

public class PersonWithError extends Person{
		
	@OneAnnotationWithStaticFieldOnly
	private int notStaticValue = 42;	
	
	@OneAnnotationWithTransientFieldOnly
	protected String oneProtectedString;	
	
	@OneAnnotationWithTransientFieldOnly
	@OneAnnotationWithFinalFieldOnly
	float oneDefaultfloat = 4.2f;	

	@OneAnnotationWithVolatileFieldOnly
	transient String oneDefaultString;

	@OneAnnotationWithFinalFieldOnly
	private volatile long oneVolatileLong = 2372983;	

	@OneAnnotationWithVolatileFieldOnly
	private static String oneStaticString = "";

	
	
	
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
