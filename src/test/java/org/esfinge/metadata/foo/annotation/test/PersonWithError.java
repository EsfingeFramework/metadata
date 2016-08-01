package org.esfinge.metadata.foo.annotation.test;

import org.esfinge.metadata.foo.annotation.FieldVisibilityForbidden;
import org.esfinge.metadata.foo.annotation.FieldVisibilityRequired;
import org.esfinge.metadata.foo.annotation.fieldonly.FinalFieldOnly;
import org.esfinge.metadata.foo.annotation.fieldonly.InstanceFieldOnly;
import org.esfinge.metadata.foo.annotation.fieldonly.StaticFieldOnly;
import org.esfinge.metadata.foo.annotation.fieldonly.TransientFieldOnly;
import org.esfinge.metadata.foo.annotation.fieldonly.VolatileFieldOnly;

public class PersonWithError extends Person{
	
	@FieldVisibilityRequired(itNeedsToHaveThisVisibility = "public")
	@FieldVisibilityForbidden(itCannotHaveThisVisibility = "private")
	@VolatileFieldOnly
	@StaticFieldOnly
	private String notStaticValue = "";
	
	@FieldVisibilityRequired(itNeedsToHaveThisVisibility = "default")
	@TransientFieldOnly
	@StaticFieldOnly
	protected String oneProtectedString;
	
	@TransientFieldOnly
	@FinalFieldOnly
	String oneFinalString;
	
	@FieldVisibilityRequired(itNeedsToHaveThisVisibility = "protected")
	@FinalFieldOnly
	@InstanceFieldOnly
	private static String oneStaticString = "";
	
	@FieldVisibilityRequired(itNeedsToHaveThisVisibility = "")
	@VolatileFieldOnly
	@InstanceFieldOnly
	private static String otherStaticString = "";
	
	public PersonWithError(String name, String cpf, int age) {
		super(name, cpf, age);
	}
	
}
